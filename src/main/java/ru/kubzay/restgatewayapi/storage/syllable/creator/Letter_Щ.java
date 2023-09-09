package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 228-235 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Щ {
    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("ЩУ", 0, 228,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЩЁ", 1, 229,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЩО", 1, 230,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЩА", 2, 231,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЩЕ", 3, 232,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЩИ", 4, 233,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЩЬ", 5, 234,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* ЩЪ не существует */
        /* "Щ" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Щ", 5, 235,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
