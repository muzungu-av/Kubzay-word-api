package ru.kubzay.restgatewayapi.storage.syllable;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kubzay.restgatewayapi.storage.syllable.column.*;
import ru.kubzay.restgatewayapi.storage.syllable.creator.*;
import ru.kubzay.restgatewayapi.storage.syllable.table.Table;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


/**
 * Управляет хранилищем слогов, букв или звуков.
 * <p>
 * Алгоритм поиска.
 * Есть слово, берем у него первые 2 буквы. Из них ищем в storage первую букву. Находим и смотрим, что это.
 * Если это гласные (У,О,А ...), то на этом поиск заканчиваем, отправляем в качестве ответа, эту букву и вторую
 * оставшуюся, с нее потом надо продолжить поиск на следующей итерации.
 * Если первая буква согласная (В,Д,Й ...), тогда два варианта:
 * 1) ищем в колонке этой согласной целиком две буквы, находим - отправляем их и в качестве ответа,
 * в поле "нераспознанные" отправляем остаток слова, так что новый поиск начнется со следующих букв в искомом слове;
 * 2) если целиком две буквы в колонке этой согласной не нашлось - то отправляем в качестве ответа саму эту согласную
 * (то есть ищем ее одну в таблице) а вторую букву из этих двух, добавим к слову (слева),
 * с нее будет продолжен поиск на следующей итерации.
 * <p>
 * Если же у слова есть только одна буква, то отправляем только ее как распознаную, в остатке отправляем пусто,
 * то есть поиск закончен.
 */
@Component
@Scope("singleton")
public class SyllableStorageHelper {

    private ArrayList<Table> tables;

    private Map<String, List<ISyllable>> consonantMap;

    @Lookup
    SyllableStorage getSyllableStorage() {
        return null;
    };

    public ParsedWordResult parseFirstSyllable(String word) throws IllegalArgumentException {
        ParsedWordResult result = new ParsedWordResult();
        HeadAndTail headAndTail = new HeadAndTail(word);
        if (headAndTail.getHeadString().length() == 2) {
            //просто отделили 2 первые буквы - нужно их найти в таблице
            Optional<ISyllable> letters1 = findConsonantSyllable(headAndTail.getHeadString());
            if (letters1.isPresent()) {
                //в таблице найден слог из двух букв, где первая согласная
                result.setHeadSyllable(letters1.get());
                result.setHeadIsVowel(false);
                result.setTailOfWord(headAndTail.getTailString());
                result.setEmptyTail(headAndTail.getTailString().isEmpty());
                result.setError(false);
            } else {
                //тут вариант что две буквы, но их нет в таблице (либо это две согласные, лиюо первая гласная)
                //просто их разделяем, берем первую букву и возвращаем
                Optional<ISyllable> letters2 = findSyllableByOneLetter(headAndTail.getHeadString());
                if (letters2.isPresent()) {
                    result.setHeadSyllable(letters2.get());
                    //todo тест на этот кейс 235-244
                    if ((letters2.get().getGlobalSyllableIndex() >= 235 & letters2.get().getGlobalSyllableIndex() <= 244)) {
                        result.setHeadIsVowel(true);
                    } else {
                        result.setHeadIsVowel(false);
                    }
                    result.setTailOfWord(headAndTail.getHeadString().substring(1) + headAndTail.getTailString());
                    result.setEmptyTail(result.getTailOfWord().isEmpty());
                    result.setError(false);
                } else {
                    //todo log ошибка
                    result.setHeadSyllable(createEmptySyllable());
                    result.setTailOfWord(headAndTail.getHeadString() + headAndTail.getTailString());
                    result.setError(true);
                }
            }
        } else {
            //отделилась одна первая буква так как больше нет - скорее всего это конец парсинга.
            Optional<ISyllable> letters3 = findSyllableByOneLetter(headAndTail.getHeadString());
            if (letters3.isPresent()) {
                result.setHeadSyllable(letters3.get());
                if ((letters3.get().getGlobalSyllableIndex() >= 235 & letters3.get().getGlobalSyllableIndex() <= 244)) {
                    result.setHeadIsVowel(true);
                } else {
                    result.setHeadIsVowel(false);
                }
                result.setTailOfWord("");
                result.setEmptyTail(true);
                result.setError(false);
            } else {
                //todo log ошибка
                result.setError(true);
                result.setHeadSyllable(createEmptySyllable());
                result.setTailOfWord(headAndTail.getHeadString() + headAndTail.getTailString());
            }
            return result;
        }
        return result;
    }

    /**
     * вернет один элемент Syllable или гласную или согласную.
     *
     * @param oneLetter String. будет использованна одна буква
     * @return Optional<ISyllable>
     */
    private Optional<ISyllable> findSyllableByOneLetter(final String oneLetter) {
        String firstLetter = oneLetter.substring(0, 1); //нужна точно только одна буква
        SyllableStorageIterator vowelsIterator = getSyllableStorage().getVowelsIterator();
        Syllable vowelSyllable = null;
        while (vowelsIterator.hasNext()) {
            Syllable obj = (Syllable) vowelsIterator.next();
            if (firstLetter.equals(obj.getSymbol())) {
                vowelSyllable = obj;
                break;
            }
        }
        if (vowelSyllable != null) {
            return Optional.of(vowelSyllable);
        }
        return findConsonantSyllable(firstLetter);
    }

    /**
     * возращает найденый слог если он начинается с согласной или пусто.
     *
     * @param letters слог из 2х неизвестных букв. ожидается что первая должна быть согласная.
     * @return Optional<ISyllable>
     */
    private Optional<ISyllable> findConsonantSyllable(String letters) {
        final AtomicReference<ISyllable> result = new AtomicReference<>();
        this.consonantMap.forEach((key, list) -> {
            SyllableStorageIterator iter = getSyllableStorage().getConsonantIterator(key);
            while (iter.hasNext()) {
                ISyllable syllable = iter.next();
                if (letters.equals(syllable.getSymbol())) {
                    result.set(syllable);
                }
            }
        });
        return result.get() != null ? Optional.of(result.get()) : Optional.empty();
    }

    private ISyllable createEmptySyllable() {
        return new ISyllable() {
            @Override
            public int compareTo(ISyllable o) {
                return 0;
            }

            @Override
            public String getSymbol() {
                return "";
            }

            @Override
            public Integer getColumnPosNumber() {
                return null;
            }

            @Override
            public Location getColumnLocation() {
                return null;
            }

            @Override
            public Location getTableLocation() {
                return null;
            }

            @Override
            public Integer getGlobalSyllableIndex() {
                return null;
            }
        };
    }

    @PostConstruct
    void storageInitialization() {
        ArrayList<ISyllable> solidArray = new ArrayList<>();
        ArrayList<ISyllable> softArray = new ArrayList<>();
        SolidSoftPairColumn solidSoftPairColumnTop;
        SolidSoftPairColumn solidSoftPairColumnBottom;
        RingingDeafPairColumn tableColumn;
        tables = new ArrayList<>();

        /* таблица 1 */
        Table table = new Table();

        /* гласные
         * У гласных Global Syllable Index - самый максимальный тк они должны быть отысканы последними */
        /* твердые У-Ы */
        solidArray = Letter_УИ.createSolid(new ArrayList<>());
        /* мягкие Ю-И */
        softArray = Letter_УИ.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addVowels(softArray);
        getSyllableStorage().addVowels(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* Й */
        /* мягкие Й */
        softArray = Letter_Й.createSoft(new ArrayList<>());
        solidSoftPairColumnTop = new SolidSoftPairColumn(null, new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* Л */
        /* твердые Л */
        solidArray = Letter_Л.createSolid(new ArrayList<>());
        /* мягкие Л */
        softArray = Letter_Л.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* М */
        /* твердые М */
        solidArray = Letter_М.createSolid(new ArrayList<>());
        /* мягкие М */
        softArray = Letter_М.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        tables.add(table);

        /* таблица 2 */
        table = new Table();

        /* Н */
        /* твердые Н */
        solidArray = Letter_Н.createSolid(new ArrayList<>());
        /* мягкие Н */
        softArray = Letter_Н.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* Р */
        /* твердые Р */
        solidArray = Letter_Р.createSolid(new ArrayList<>());
        /* мягкие Р */
        softArray = Letter_Р.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* В */
        /* твердые В */
        solidArray = Letter_В.createSolid(new ArrayList<>());
        /* мягкие В */
        softArray = Letter_В.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* Ф */
        /* твердые Ф */
        solidArray = Letter_Ф.createSolid(new ArrayList<>());
        /* мягкие Ф */
        softArray = Letter_Ф.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* З */
        /* твердые З */
        solidArray = Letter_З.createSolid(new ArrayList<>());
        /* мягкие З */
        softArray = Letter_З.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* С */
        /* твердые С */
        solidArray = Letter_С.createSolid(new ArrayList<>());
        /* мягкие С */
        softArray = Letter_С.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);
        tables.add(table);

        /* таблица 3 */
        table = new Table();

        /* Б */
        /* твердые Б */
        solidArray = Letter_Б.createSolid(new ArrayList<>());
        /* мягкие В */
        softArray = Letter_Б.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* П */
        /* твердые П */
        solidArray = Letter_П.createSolid(new ArrayList<>());
        /* мягкие П */
        softArray = Letter_П.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Д */
        /* твердые Д */
        solidArray = Letter_Д.createSolid(new ArrayList<>());
        /* мягкие Д */
        softArray = Letter_Д.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* Т */
        /* твердые Т */
        solidArray = Letter_Т.createSolid(new ArrayList<>());
        /* мягкие Т */
        softArray = Letter_Т.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Г */
        /* твердые Г */
        solidArray = Letter_Г.createSolid(new ArrayList<>());
        /* мягкие Г */
        softArray = Letter_Г.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* К */
        /* твердые К */
        solidArray = Letter_К.createSolid(new ArrayList<>());
        /* мягкие К */
        softArray = Letter_К.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Х */
        /* твердые Х */
        solidArray = Letter_Х.createSolid(new ArrayList<>());
        /* мягкие Х */
        softArray = Letter_Х.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(null, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);
        tables.add(table);

        /* таблица 4 */
        table = new Table();

        /* Ж */
        /* твердые Ж */
        solidArray = Letter_Ж.createSolid(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), null);
        getSyllableStorage().addConsonant(solidArray);

        /* Ш */
        /* твердые Ш */
        solidArray = Letter_Ш.createSolid(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), null);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Ц */
        /* твердые Ц */
        solidArray = Letter_Ц.createSolid(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), null);
        getSyllableStorage().addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(null, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Ч */
        /* мягкие Ч */
        softArray = Letter_Ч.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(null, new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(null, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Щ */
        /* мягкие Щ */
        softArray = Letter_Щ.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(null, new SoftColumn(softArray));
        getSyllableStorage().addConsonant(softArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(null, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);
        tables.add(table);

        /* знаки Ь,Ъ */
        getSyllableStorage().addVowels(Letter_ЬЪ.create(new ArrayList<>()));

        /* инициализация итераторов */
        getSyllableStorage().setVowelsIterator();
        getSyllableStorage().setConsonantIterator();
//        this.vowelsIterator = getSyllableStorage().getVowelsIterator();
        this.consonantMap = getSyllableStorage().getConsonant();
    }
}
