package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 83-95 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Б {

    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("БУ", 0, 83,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БО", 1, 84,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БА", 2, 85,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БЭ", 3, 86,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БЫ", 4, 87,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БЪ", 6, 88,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* "Б" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Б", 5, 95,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("БЮ", 0, 89,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БЁ", 1, 90,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БЯ", 2, 91,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БЕ", 3, 92,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БИ", 4, 93,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("БЬ", 5, 94,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
