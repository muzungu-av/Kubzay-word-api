package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 205-212 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Ш {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("ШУ", 0, 205,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ШЁ", 1, 206,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ШО", 1, 207,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ША", 2, 208,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ШЕ", 3, 209,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ШИ", 4, 210,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ШЬ", 5, 211,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* ШЪ не существует */
        /* "Ш" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Ш", 5, 212,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
