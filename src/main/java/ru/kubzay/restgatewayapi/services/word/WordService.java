package ru.kubzay.restgatewayapi.services.word;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.kubzay.restgatewayapi.storage.syllable.ParsedWordResult;
import ru.kubzay.restgatewayapi.storage.syllable.SyllableStorageHelper;

import java.util.LinkedList;

@Service
public class WordService {

    @Lookup
    SyllableStorageHelper getSyllableStorageHelper() {
        return null;
    }

    public LinkedList<ParsedWordResult> parseOneWord(final String word) {
        SyllableStorageHelper helper = getSyllableStorageHelper();
        String tailWord = new String(word);
        LinkedList<ParsedWordResult> resultList = new LinkedList<>();
        ParsedWordResult pwr = null;
        boolean a1 = true;
        boolean a2 = true;
        while (a1 && a2) {
            if (!tailWord.isEmpty()) {
                pwr = helper.parseFirstSyllable(tailWord);
            } else {
                break;
            }
            if (pwr != null) {
                resultList.add(pwr);
            }
            tailWord = pwr.getTailOfWord();
            a1 = !pwr.isEmptyTail();
            a2 = !pwr.isError();
        }
        return resultList;
    }
}