package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 70-82 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_З {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("ЗУ", 0, 70,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗО", 1, 71,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗА", 2, 72,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗЭ", 3, 73,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗЫ", 4, 74,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗЪ", 6, 75,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* "З" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("З", 5, 82,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("ЗЮ", 0, 76,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗЁ", 1, 77,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗЯ", 2, 78,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗЕ", 3, 79,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗИ", 4, 80,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЗЬ", 5, 81,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
