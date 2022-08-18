package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 44-56 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Р {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("РУ", 0, 44,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РО", 1, 45,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РА", 2, 46,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РЭ", 3, 47,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РЫ", 4, 48,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РЪ", 6, 49,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* "Р" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Р", 5, 56,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("РЮ", 0, 50,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РЁ", 1, 51,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РЯ", 2, 52,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РЕ", 3, 53,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РИ", 4, 54,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("РЬ", 5, 55,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
