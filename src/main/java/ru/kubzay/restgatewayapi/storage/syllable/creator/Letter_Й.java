package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* у буквы Й нет твердых звуков */
/* global syllable index: 0-6 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Й {
    public static ArrayList<ISyllable> createSoft(ArrayList<ISyllable> array) {
        if (array == null) {
            return array;
        }
        array.add(new Syllable("ЙЮ", 0, 0,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЙО", 1, 1,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЙА", 2, 2,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* ЙА, ЙЯ обе на третьем месте в своей колонке */
        array.add(new Syllable("ЙЯ", 2, 3,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЙЕ", 3, 4,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЙИ", 4, 5,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("Й", 5, 6,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
