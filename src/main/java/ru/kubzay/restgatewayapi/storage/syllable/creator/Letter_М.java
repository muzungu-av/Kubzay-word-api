package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 19-30 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_М {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("МУ", 0, 19,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МО", 1, 20,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МА", 2, 21,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МЭ", 3, 22,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МЫ", 4, 23,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        /* "Л" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("М", 5, 30,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        // МЪ не существует
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("МЮ", 0, 24,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МЁ", 1, 25,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МЯ", 2, 26,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МЕ", 3, 27,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МИ", 4, 28,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("МЬ", 5, 29,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
