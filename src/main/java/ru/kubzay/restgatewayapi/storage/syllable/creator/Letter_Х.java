package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 192-204 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Х {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("ХУ", 0, 192,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХО", 1, 193,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХА", 2, 194,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХЭ", 3, 195,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХЫ", 4, 196,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХЪ", 6, 197,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* "Х" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Х", 5, 204,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("ХЮ", 0, 198,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХЁ", 1, 199,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХЯ", 2, 200,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХЕ", 3, 201,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХИ", 4, 202,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ХЬ", 5, 203,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
