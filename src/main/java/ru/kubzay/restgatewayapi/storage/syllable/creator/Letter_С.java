package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 142-154 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_С {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("СУ", 0, 142,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СО", 1, 143,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СА", 2, 144,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СЭ", 3, 145,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СЫ", 4, 146,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СЪ", 6, 147,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* "Р" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("С", 5, 154,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("СЮ", 0, 148,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СЁ", 1, 149,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СЯ", 2, 150,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СЕ", 3, 151,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СИ", 4, 152,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("СЬ", 5, 153,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
