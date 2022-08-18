package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 31-43 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Н {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("НУ", 0, 31,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НО", 1, 32,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НА", 2, 33,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НЭ", 3, 34,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НЫ", 4, 35,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НЪ", 6, 36,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* "Н" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Н", 5, 43,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("НЮ", 0, 37,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НЁ", 1, 38,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НЯ", 2, 39,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НЕ", 3, 40,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НИ", 4, 41,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("НЬ", 5, 42,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
