package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 180-191 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_К {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("КУ", 0, 180,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КО", 1, 181,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КА", 2, 182,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КЭ", 3, 183,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КЫ", 4, 184,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* КЪ не существует */
        /* "К" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("К", 5, 191,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }

    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("КЮ", 0, 185,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КЁ", 1, 186,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КЯ", 2, 187,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КЕ", 3, 188,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КИ", 4, 189,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("КЬ", 5, 190,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
