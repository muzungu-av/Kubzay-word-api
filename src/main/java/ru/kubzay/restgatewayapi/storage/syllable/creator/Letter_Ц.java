package ru.kubzay.restgatewayapi.storage.syllable.creator;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;
import ru.kubzay.restgatewayapi.storage.syllable.Syllable;
import ru.kubzay.restgatewayapi.storage.syllable.column.ColumnLocation;
import ru.kubzay.restgatewayapi.storage.syllable.table.TableLocation;

import java.util.ArrayList;

/* global syllable index: 213-219 */
@SuppressWarnings("NonAsciiCharacters")
public class Letter_Ц {
    public static ArrayList<ISyllable> createSolid(ArrayList<ISyllable> array) {
        if (array == null) {
            return null;
        }
        array.add(new Syllable("ЦУ", 0, 213,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЦО", 1, 214,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЦА", 2, 215,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЦЕ", 3, 216,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЦИ", 4, 217,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));

        array.add(new Syllable("ЦЫ", 4, 218,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        /* ЦЬ, ЦЪ не существуют */
        /* "Ц" должна быть последняя по globalSyllableIndex-у */
        array.add(new Syllable("Ц", 5, 219,
                new ColumnLocation(0, 0),
                new TableLocation(0, 0)));
        return array;
    }
}
