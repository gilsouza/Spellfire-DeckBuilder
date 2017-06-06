package br.com.gilsouza.spellfiredeckbuilder.db.schema;

/**
 * Created by gilmar on 04/06/17.
 */

public interface ICardSchema {
    String CARD_TABLE_NAME = "cards";
    String COLUMN_CINDEX = "cIndex";
    String COLUMN_COLLECTION = "Collection";
    String COLUMN_NUMBER = "Number";
    String COLUMN_BONUS = "Bonus";
    String COLUMN_TYPE = "Type";
    String COLUMN_WORLD = "World";
    String COLUMN_TITLE = "Title";
    String COLUMN_TEXT = "Text";
    String COLUMN_FREQUENCY = "Frequency";
    String COLUMN_BLUELINE = "Blueline";
    String COLUMN_AINDEX = "aIndex";
    String COLUMN_UINDEX = "uIndex";

    String[] CARD_COLUMNS = new String[] { COLUMN_CINDEX, COLUMN_COLLECTION, COLUMN_NUMBER, COLUMN_BONUS,
            COLUMN_TYPE, COLUMN_WORLD, COLUMN_TITLE, COLUMN_TEXT, COLUMN_FREQUENCY, COLUMN_BLUELINE,
            COLUMN_AINDEX, COLUMN_UINDEX };

    String[] CARD_COLUMNS_WHERE = new String[] { COLUMN_COLLECTION, COLUMN_NUMBER, COLUMN_BONUS,
            COLUMN_TYPE, COLUMN_WORLD, COLUMN_TITLE, COLUMN_TEXT, COLUMN_FREQUENCY, COLUMN_BLUELINE};
}