package ru.kubzay.restgatewayapi.storage.syllable;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kubzay.restgatewayapi.storage.syllable.column.*;
import ru.kubzay.restgatewayapi.storage.syllable.creator.*;
import ru.kubzay.restgatewayapi.storage.syllable.table.Table;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


/**
 * Управляет хранилищем слогов, букв или звуков.
 * <p>
 * Алгоритм поиска.
 * Есть слово, берем у него первые 2 буквы. Из них ищем в storage первую букву. Находим и смотрим, что это.
 * Если это гласные (У,О,А ...), то на этом поиск заканчиваем, отправляем в качестве ответа, эту букву и вторую
 * оставшуюся, с нее потом надо продолжить поиск на следующей итерации.
 * Если первая буква согласная (В,Д,Й ...), тогда два варианта:
 * 1) ищем в колонке этой согласной целиком две буквы, находим - отправляем их и в качестве ответа, в поле "нераспознанные"
 * отправляем "пусто", так что новый поиск начнется со следующих букв в искомом слове;
 * 2) если целиком две буквы в колонке этой согласной не нашлось - то отправляем в качестве ответа саму эту согласную
 * и вторую букву с которой будет продолжен поиск на следующей итерации.
 */
@Component
@Scope("singleton")
public class SyllableStorageHelper {

    private SyllableStorage syllableStorage;

    private ArrayList<Table> tables;

    @Lookup
    public SyllableStorage getSyllableStorage() {
        return null;
    }

    @PostConstruct
    void storageInitialization() {
        syllableStorage = new SyllableStorage();
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
        syllableStorage.addVowels(softArray);
        syllableStorage.addVowels(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);
         
        /* Й */
        /* мягкие Й */
        softArray = Letter_Й.createSoft(new ArrayList<>());
        solidSoftPairColumnTop = new SolidSoftPairColumn(null, new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* Л */
        /* твердые Л */
        solidArray = Letter_Л.createSolid(new ArrayList<>());
        /* мягкие Л */
        softArray = Letter_Л.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* М */
        /* твердые М */
        solidArray = Letter_М.createSolid(new ArrayList<>());
        /* мягкие М */
        softArray = Letter_М.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);
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
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* Р */
        /* твердые Р */
        solidArray = Letter_Р.createSolid(new ArrayList<>());
        /* мягкие Р */
        softArray = Letter_Р.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, null);
        table.addColumn(tableColumn);

        /* В */
        /* твердые В */
        solidArray = Letter_В.createSolid(new ArrayList<>());
        /* мягкие В */
        softArray = Letter_В.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnTop = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

        /* Ф */
        /* твердые Ф */
        solidArray = Letter_Ф.createSolid(new ArrayList<>());
        /* мягкие Ф */
        softArray = Letter_Ф.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

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
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

        /* С */
        /* твердые С */
        solidArray = Letter_С.createSolid(new ArrayList<>());
        /* мягкие С */
        softArray = Letter_С.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

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
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

        /* П */
        /* твердые П */
        solidArray = Letter_П.createSolid(new ArrayList<>());
        /* мягкие П */
        softArray = Letter_П.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

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
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

        /* Т */
        /* твердые Т */
        solidArray = Letter_Т.createSolid(new ArrayList<>());
        /* мягкие Т */
        softArray = Letter_Т.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

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
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

        /* К */
        /* твердые К */
        solidArray = Letter_К.createSolid(new ArrayList<>());
        /* мягкие К */
        softArray = Letter_К.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

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
        syllableStorage.addConsonant(softArray);
        syllableStorage.addConsonant(solidArray);

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
        syllableStorage.addConsonant(solidArray);

        /* Ш */
        /* твердые Ш */
        solidArray = Letter_Ш.createSolid(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), null);
        syllableStorage.addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(solidSoftPairColumnTop, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Ц */
        /* твердые Ц */
        solidArray = Letter_Ц.createSolid(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(new SolidColumn(solidArray), null);
        syllableStorage.addConsonant(solidArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(null, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Ч */
        /* мягкие Ч */
        softArray = Letter_Ч.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(null, new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(null, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);

        /* Щ */
        /* мягкие Щ */
        softArray = Letter_Щ.createSoft(new ArrayList<>());
        /* пара колонок "Твердые-Мягкие" (большие-маленькие) */
        solidSoftPairColumnBottom = new SolidSoftPairColumn(null, new SoftColumn(softArray));
        syllableStorage.addConsonant(softArray);

        /* пара колонок "Звонкие-Глухие" (верхние-нижние) */
        tableColumn = new RingingDeafPairColumn(null, solidSoftPairColumnBottom);
        table.addColumn(tableColumn);
        tables.add(table);

        /* знаки Ь,Ъ */
        syllableStorage.addVowels(Letter_ЬЪ.create(new ArrayList<>()));
    }
}
