package ru.kubzay.restgatewayapi.storage.syllable.column;

import ru.kubzay.restgatewayapi.storage.syllable.ISyllable;

import java.util.ArrayList;

public interface IColumn {

    public ArrayList<ISyllable> getSyllableList();

    public ArrayList<ISyllable> getSyllableIndexIterator();

}
