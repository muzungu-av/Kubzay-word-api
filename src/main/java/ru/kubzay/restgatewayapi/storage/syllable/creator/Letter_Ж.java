package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 121-129 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Ж {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("ЖУ", 0, 121,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* "ЖЁ""ЖО"  на одном ряду */
        array.add(new Syllable("ЖЁ", 1, 122,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЖО", 1, 123,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЖА", 2, 124,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЖЕ", 3, 125,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЖИ", 4, 126,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        /* "ЖЪ" последняя в колонке */
        array.add(new Syllable("ЖЪ", 6, 127,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        /* "Ж""ЖЬ" на одном ряду */
        array.add(new Syllable("ЖЬ", 5, 128,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        /* "Ж" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Ж", 5, 129,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
