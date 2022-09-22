package ru.kubzay.restgatewayapi.services.word;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kubzay.restgatewayapi.storage.syllable.ParsedWordResult;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WordServiceTest {

    @Autowired
    private WordService service;

    // буква "У"
    @Test
    void parse1() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("УТЮГ");
        assertEquals(3, result.size());

        ParsedWordResult first = result.get(0);
        assertEquals(first.getHeadSyllable().getSymbol(), "У");
        assertEquals(first.getTailOfWord(), "ТЮГ");
        assertFalse(first.isEmptyTail());
        assertFalse(first.isError());
        assertTrue(first.isHeadIsVowel());

        ParsedWordResult second = result.get(1);
        assertEquals(second.getHeadSyllable().getSymbol(), "ТЮ");
        assertEquals(second.getTailOfWord(), "Г");
        assertFalse(second.isEmptyTail());
        assertFalse(second.isError());
        assertFalse(second.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Г");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // буква "У"
    @Test
    void parse2() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ОЧКИ");
        assertEquals(3, result.size());

        ParsedWordResult first = result.get(0);
        assertEquals(first.getHeadSyllable().getSymbol(), "О");
        assertEquals(first.getTailOfWord(), "ЧКИ");
        assertFalse(first.isEmptyTail());
        assertFalse(first.isError());
        assertTrue(first.isHeadIsVowel());

        ParsedWordResult second = result.get(1);
        assertEquals(second.getHeadSyllable().getSymbol(), "Ч");
        assertEquals(second.getTailOfWord(), "КИ");
        assertFalse(second.isEmptyTail());
        assertFalse(second.isError());
        assertFalse(second.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "КИ");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // буква "А"
    @Test
    void parse3() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("АРКА");
        assertEquals(3, result.size());

        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "А");
        assertEquals(a1.getTailOfWord(), "РКА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertEquals(a2.getTailOfWord(), "КА");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "КА");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // буква "Э"
    @Test
    void parse4() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЭВМ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "Э");
        assertEquals(a1.getTailOfWord(), "ВМ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "В");
        assertEquals(a2.getTailOfWord(), "М");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "М");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // буква "Ы"
    @Test
    void parse5() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЫЦЫЫ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "Ы");
        assertEquals(a1.getTailOfWord(), "ЦЫЫ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ЦЫ");
        assertEquals(a2.getTailOfWord(), "Ы");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Ы");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertTrue(a3.isHeadIsVowel());
    }

    // буква "Ю"
    @Test
    void parse6() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЮЛА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "Ю");
        assertEquals(a1.getTailOfWord(), "ЛА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ЛА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // буква "Ё"
    @Test
    void parse7() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЁЖЖЁЛУДЬ");
        assertEquals(5, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "Ё");
        assertEquals(a1.getTailOfWord(), "ЖЖЁЛУДЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Ж");
        assertEquals(a2.getTailOfWord(), "ЖЁЛУДЬ");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "ЖЁ");
        assertEquals(a3.getTailOfWord(), "ЛУДЬ");
        assertFalse(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());

        ParsedWordResult a4 = result.get(3);
        assertEquals(a4.getHeadSyllable().getSymbol(), "ЛУ");
        assertEquals(a4.getTailOfWord(), "ДЬ");
        assertFalse(a4.isEmptyTail());
        assertFalse(a4.isError());
        assertFalse(a4.isHeadIsVowel());

        ParsedWordResult a5 = result.get(4);
        assertEquals(a5.getHeadSyllable().getSymbol(), "ДЬ");
        assertTrue(a5.getTailOfWord().isEmpty());
        assertTrue(a5.isEmptyTail());
        assertFalse(a5.isError());
        assertFalse(a5.isHeadIsVowel());
    }

    // буква "Я"
    @Test
    void parse8() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЯХТА");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "Я");
        assertEquals(a1.getTailOfWord(), "ХТА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Х");
        assertEquals(a2.getTailOfWord(), "ТА");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "ТА");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // буква "Е"
    @Test
    void parse9() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЕЛЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "Е");
        assertEquals(a1.getTailOfWord(), "ЛЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ЛЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // буква "И"
    @Test
    void parse10() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ИРА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "И");
        assertEquals(a1.getTailOfWord(), "РА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "РА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МА"
    @Test
    void parse11() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МАШИНА");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МА");
        assertEquals(a1.getTailOfWord(), "ШИНА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ШИ");
        assertEquals(a2.getTailOfWord(), "НА");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "НА");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "МУ"
    @Test
    void parse12() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МУХА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МУ");
        assertEquals(a1.getTailOfWord(), "ХА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ХА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МО"
    @Test
    void parse13() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МОР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МО");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МЭ"
    @Test
    void parse14() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МЭР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МЭ");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МЫ"
    @Test
    void parse15() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МЫШЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МЫ");
        assertEquals(a1.getTailOfWord(), "ШЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ШЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МЮ"
    @Test
    void parse16() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МЮСЛИ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МЮ");
        assertEquals(a1.getTailOfWord(), "СЛИ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "С");
        assertEquals(a2.getTailOfWord(), "ЛИ");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "ЛИ");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "МЁ"
    @Test
    void parse17() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МЁД");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МЁ");
        assertEquals(a1.getTailOfWord(), "Д");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Д");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МЯ"
    @Test
    void parse18() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МЯЧ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МЯ");
        assertEquals(a1.getTailOfWord(), "Ч");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Ч");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МЕ"
    @Test
    void parse19() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МЕЧ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МЕ");
        assertEquals(a1.getTailOfWord(), "Ч");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Ч");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МИ"
    @Test
    void parse20() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МИР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МИ");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "МЬ"
    @Test
    void parse21() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("КОМЬЯ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "КО");
        assertEquals(a1.getTailOfWord(), "МЬЯ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "МЬ");
        assertEquals(a2.getTailOfWord(), "Я");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Я");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertTrue(a3.isHeadIsVowel());
    }

    // буквы "М" и "Ъ"
    @Test
    void parse211() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("МЬМЪ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "МЬ");
        assertEquals(a1.getTailOfWord(), "МЪ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "М");
        assertEquals(a2.getTailOfWord(), "Ъ");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Ъ");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // буква "Н"
    @Test
    void parse22() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("КРАН");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "К");
        assertEquals(a1.getTailOfWord(), "РАН");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "РА");
        assertEquals(a2.getTailOfWord(), "Н");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Н");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "НУ"
    @Test
    void parse23() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НУТ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НУ");
        assertEquals(a1.getTailOfWord(), "Т");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Т");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НО"
    @Test
    void parse24() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НОС");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НО");
        assertEquals(a1.getTailOfWord(), "С");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "С");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НА"
    @Test
    void parse25() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НАСТЯ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НА");
        assertEquals(a1.getTailOfWord(), "СТЯ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "С");
        assertEquals(a2.getTailOfWord(), "ТЯ");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "ТЯ");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "НЭ"
    @Test
    void parse26() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НЭП");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НЭ");
        assertEquals(a1.getTailOfWord(), "П");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "П");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НЫ"
    @Test
    void parse27() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СНЫ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "С");
        assertEquals(a1.getTailOfWord(), "НЫ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "НЫ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НЮ"
    @Test
    void parse28() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НЮРА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НЮ");
        assertEquals(a1.getTailOfWord(), "РА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "РА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НЁ"
    @Test
    void parse29() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НЁБО");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НЁ");
        assertEquals(a1.getTailOfWord(), "БО");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "БО");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НЯ"
    @Test
    void parse30() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НЯНЯ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НЯ");
        assertEquals(a1.getTailOfWord(), "НЯ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "НЯ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НЕ"
    @Test
    void parse31() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НЕМ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НЕ");
        assertEquals(a1.getTailOfWord(), "М");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "М");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НИ"
    @Test
    void parse32() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("НИТЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "НИ");
        assertEquals(a1.getTailOfWord(), "ТЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ТЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НЬ"
    @Test
    void parse33() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ДЕНЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ДЕ");
        assertEquals(a1.getTailOfWord(), "НЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "НЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "НЪ"
    @Test
    void parse34() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЁНЪЪ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "Ё");
        assertEquals(a1.getTailOfWord(), "НЪЪ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "НЪ");
        assertEquals(a2.getTailOfWord(), "Ъ");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Ъ");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "РУ"
    @Test
    void parse35() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РУКА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РУ");
        assertEquals(a1.getTailOfWord(), "КА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "КА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РО"
    @Test
    void parse36() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РОТ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РО");
        assertEquals(a1.getTailOfWord(), "Т");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Т");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РА"
    @Test
    void parse37() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РАК");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РА");
        assertEquals(a1.getTailOfWord(), "К");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "К");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РЭ"
    @Test
    void parse38() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РЭП");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РЭ");
        assertEquals(a1.getTailOfWord(), "П");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "П");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РЫ"
    @Test
    void parse39() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РЫБА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РЫ");
        assertEquals(a1.getTailOfWord(), "БА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "БА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // буква "Р"
    @Test
    void parse40() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("АРКА");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "А");
        assertEquals(a1.getTailOfWord(), "РКА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertTrue(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertEquals(a2.getTailOfWord(), "КА");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "КА");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "РЮ"
    @Test
    void parse41() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РЮША");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РЮ");
        assertEquals(a1.getTailOfWord(), "ША");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ША");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РЁ"
    @Test
    void parse42() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РЁВА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РЁ");
        assertEquals(a1.getTailOfWord(), "ВА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ВА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РЯ"
    @Test
    void parse43() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РЯБА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РЯ");
        assertEquals(a1.getTailOfWord(), "БА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "БА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РЕ"
    @Test
    void parse44() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РЕКА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РЕ");
        assertEquals(a1.getTailOfWord(), "КА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "КА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РИ"
    @Test
    void parse45() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РИС");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РИ");
        assertEquals(a1.getTailOfWord(), "С");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "С");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РЬ"
    @Test
    void parse46() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("КОРЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "КО");
        assertEquals(a1.getTailOfWord(), "РЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "РЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "РЪ"
    @Test
    void parse47() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("РЪЪ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "РЪ");
        assertEquals(a1.getTailOfWord(), "Ъ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Ъ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СУ"
    @Test
    void parse48() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СУП");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СУ");
        assertEquals(a1.getTailOfWord(), "П");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "П");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СО"
    @Test
    void parse49() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СОН");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СО");
        assertEquals(a1.getTailOfWord(), "Н");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Н");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СА"
    @Test
    void parse50() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("САНИ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СА");
        assertEquals(a1.getTailOfWord(), "НИ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "НИ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СЭ"
    @Test
    void parse51() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СЭР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СЭ");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СЫ"
    @Test
    void parse52() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СЫР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СЫ");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // буква "С"
    @Test
    void parse53() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СССР");
        assertEquals(4, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "С");
        assertEquals(a1.getTailOfWord(), "ССР");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "С");
        assertEquals(a2.getTailOfWord(), "СР");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "С");
        assertEquals(a3.getTailOfWord(), "Р");
        assertFalse(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());

        ParsedWordResult a4 = result.get(3);
        assertEquals(a4.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a4.getTailOfWord().isEmpty());
        assertTrue(a4.isEmptyTail());
        assertFalse(a4.isError());
        assertFalse(a4.isHeadIsVowel());
    }

    // буква "СЮ"
    @Test
    void parse54() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СЮРТУК");
        assertEquals(4, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СЮ");
        assertEquals(a1.getTailOfWord(), "РТУК");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertEquals(a2.getTailOfWord(), "ТУК");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "ТУ");
        assertEquals(a3.getTailOfWord(), "К");
        assertFalse(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());

        ParsedWordResult a4 = result.get(3);
        assertEquals(a4.getHeadSyllable().getSymbol(), "К");
        assertTrue(a4.getTailOfWord().isEmpty());
        assertTrue(a4.isEmptyTail());
        assertFalse(a4.isError());
        assertFalse(a4.isHeadIsVowel());
    }

    // слог "СЁ"
    @Test
    void parse55() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СЁМГА");
        assertEquals(3, result.size());
        ParsedWordResult a2 = result.get(0);
        assertEquals(a2.getHeadSyllable().getSymbol(), "СЁ");
        assertEquals(a2.getTailOfWord(), "МГА");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(1);
        assertEquals(a3.getHeadSyllable().getSymbol(), "М");
        assertEquals(a3.getTailOfWord(), "ГА");
        assertFalse(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());

        ParsedWordResult a4 = result.get(2);
        assertEquals(a4.getHeadSyllable().getSymbol(), "ГА");
        assertTrue(a4.getTailOfWord().isEmpty());
        assertTrue(a4.isEmptyTail());
        assertFalse(a4.isError());
        assertFalse(a4.isHeadIsVowel());
    }

    // слог "СЯ"
    @Test
    void parse56() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СЯОМИ");
        assertEquals(3, result.size());
        ParsedWordResult a2 = result.get(0);
        assertEquals(a2.getHeadSyllable().getSymbol(), "СЯ");
        assertEquals(a2.getTailOfWord(), "ОМИ");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(1);
        assertEquals(a3.getHeadSyllable().getSymbol(), "О");
        assertEquals(a3.getTailOfWord(), "МИ");
        assertFalse(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertTrue(a3.isHeadIsVowel());

        ParsedWordResult a4 = result.get(2);
        assertEquals(a4.getHeadSyllable().getSymbol(), "МИ");
        assertTrue(a4.getTailOfWord().isEmpty());
        assertTrue(a4.isEmptyTail());
        assertFalse(a4.isError());
        assertFalse(a4.isHeadIsVowel());
    }

    // слог "СЕ"
    @Test
    void parse57() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СЕНО");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СЕ");
        assertEquals(a1.getTailOfWord(), "НО");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "НО");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СИ"
    @Test
    void parse58() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("СИР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "СИ");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СЬ"
    @Test
    void parse59() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ЛОСЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ЛО");
        assertEquals(a1.getTailOfWord(), "СЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "СЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "СЪ"
    @Test
    void parse60() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ССЪЪ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "С");
        assertEquals(a1.getTailOfWord(), "СЪЪ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "СЪ");
        assertEquals(a2.getTailOfWord(), "Ъ");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Ъ");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "ПУ"
    @Test
    void parse61() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПУЛЯ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПУ");
        assertEquals(a1.getTailOfWord(), "ЛЯ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ЛЯ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПО"
    @Test
    void parse62() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПОП");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПО");
        assertEquals(a1.getTailOfWord(), "П");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "П");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПА"
    @Test
    void parse63() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПАР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПА");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПЭ"
    @Test
    void parse64() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПЭР");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПЭ");
        assertEquals(a1.getTailOfWord(), "Р");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПЫ"
    @Test
    void parse65() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПЫЛЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПЫ");
        assertEquals(a1.getTailOfWord(), "ЛЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ЛЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // буква "П"
    @Test
    void parse66() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("КЛОП");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "К");
        assertEquals(a1.getTailOfWord(), "ЛОП");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ЛО");
        assertEquals(a2.getTailOfWord(), "П");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "П");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "ПЮ"
    @Test
    void parse67() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПЮРЕ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПЮ");
        assertEquals(a1.getTailOfWord(), "РЕ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "РЕ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПЁ"
    @Test
    void parse68() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПЁТР");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПЁ");
        assertEquals(a1.getTailOfWord(), "ТР");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Т");
        assertEquals(a2.getTailOfWord(), "Р");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Р");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertFalse(a3.isHeadIsVowel());
    }

    // слог "ПЯ"
    @Test
    void parse69() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПЯТЬ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПЯ");
        assertEquals(a1.getTailOfWord(), "ТЬ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ТЬ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПЕ"
    @Test
    void parse70() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПЕТЯ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПЕ");
        assertEquals(a1.getTailOfWord(), "ТЯ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ТЯ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПИ"
    @Test
    void parse71() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПИЛА");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "ПИ");
        assertEquals(a1.getTailOfWord(), "ЛА");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ЛА");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }

    // слог "ПЬ"
    @Test
    void parse72() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("КОПЬЁ");
        assertEquals(3, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "КО");
        assertEquals(a1.getTailOfWord(), "ПЬЁ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "ПЬ");
        assertEquals(a2.getTailOfWord(), "Ё");
        assertFalse(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());

        ParsedWordResult a3 = result.get(2);
        assertEquals(a3.getHeadSyllable().getSymbol(), "Ё");
        assertTrue(a3.getTailOfWord().isEmpty());
        assertTrue(a3.isEmptyTail());
        assertFalse(a3.isError());
        assertTrue(a3.isHeadIsVowel());
    }

    // буквы "П" и "Ъ"
    @Test
    void parse73() {
        LinkedList<ParsedWordResult> result = service.parseOneWord("ПЪ");
        assertEquals(2, result.size());
        ParsedWordResult a1 = result.get(0);
        assertEquals(a1.getHeadSyllable().getSymbol(), "П");
        assertEquals(a1.getTailOfWord(), "Ъ");
        assertFalse(a1.isEmptyTail());
        assertFalse(a1.isError());
        assertFalse(a1.isHeadIsVowel());

        ParsedWordResult a2 = result.get(1);
        assertEquals(a2.getHeadSyllable().getSymbol(), "Ъ");
        assertTrue(a2.getTailOfWord().isEmpty());
        assertTrue(a2.isEmptyTail());
        assertFalse(a2.isError());
        assertFalse(a2.isHeadIsVowel());
    }
}