package ru.kubzay.restgatewayapi.storage.syllable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Хранилище слогов. Синглтон.
 * <p>
 * Хранит все возможные разновидности сочетаний слогов-букв русского языка.
 * За основу взяты таблицы методики Зайцева.
 * <p>
 * Гласные храняться в отдельном листе, согласные в другом.
 * <p>
 * Ранее планировалось всё хранить в одном листе, поэтому был введен GlobalSyllableIndex,
 * и поддерживается такая нумерация, которая обеспечивает корректный разбор слова на слоги
 * (одиночные согласные буквы имеют более высокий индекс, чем слоги с этими согласными);
 * однако разделив одну коллекцию на несколько, индекс хотя остался и является по-прежнему необходимым,
 * все таки утрантил свой первоначальный смысл...
 */
@Component
@Scope("singleton")
public class SyllableStorage {

    ArrayList<ISyllable> vowels;                          //гласные
    HashMap<String, ArrayList<ISyllable>> consonant;      //согласные

    public SyllableStorage() {
        vowels = new ArrayList<>();
        consonant = new HashMap<>();
    }

    public void addVowels(ArrayList<ISyllable> array) {
        vowels.addAll(array);
    }

    public void addConsonant(ArrayList<ISyllable> array) {
        if (array == null || array.size() == 0) {
            return;
        }
        String key = String.valueOf(array.get(0).getSymbol().charAt(0));
        if (consonant.containsKey(key)) {
            consonant.get(key).addAll(array);
        } else {
            consonant.put(key, array);
        }
    }
}