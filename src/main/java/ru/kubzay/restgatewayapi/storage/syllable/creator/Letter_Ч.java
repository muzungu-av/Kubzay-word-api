package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 220-227 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Ч {
    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("ЧУ", 0, 220,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЧЁ", 1, 221,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЧО", 1, 222,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЧА", 2, 223,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЧЕ", 3, 224,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЧИ", 4, 225,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЧЬ", 5, 226,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* ЧЪ не существует */
        /* "Ч" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Ч", 5, 227,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
