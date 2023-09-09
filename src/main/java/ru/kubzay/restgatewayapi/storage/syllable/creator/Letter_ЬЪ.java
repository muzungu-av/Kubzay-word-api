package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 245-246 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_ЬЪ {
    public static ArrayList<ISyllable> create(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }

        array.add(new Syllable("Ь", 4, 245,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("Ъ", 4, 246,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
