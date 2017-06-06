package br.com.gilsouza.spellfiredeckbuilder.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.gilsouza.spellfiredeckbuilder.db.DbContentProvider;
import br.com.gilsouza.spellfiredeckbuilder.db.schema.ICardSchema;
import br.com.gilsouza.spellfiredeckbuilder.model.Card;

/**
 * Created by gilmar on 04/06/17.
 */

public class CardDAO extends DbContentProvider
        implements ICardSchema, ICardDAO {
    private Cursor cursor;
    private ContentValues initialValues;

    public CardDAO(SQLiteDatabase db) {
        super(db);
    }

    @Override
    public Card fetchCardById(int cardId) {
        final String selectionArgs[] = {String.valueOf(cardId)};
        final String selection = COLUMN_CINDEX + " = ?";

        Card card = new Card();

        cursor = super.query(CARD_TABLE_NAME, CARD_COLUMNS, selection,
                selectionArgs, COLUMN_CINDEX);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                card = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return card;
    }

    @Override
    public List<Card> fetchAllCards() {
        return null;
    }

    @Override
    public List<Card> fetchAllCardsBySpecs(Card cardEspecs) {
        final String selectionArgs[] = {
                "%" + cardEspecs.collection + "%",
                "%" + String.valueOf(cardEspecs.number) + "%",
                "%" + cardEspecs.bonus + "%",
                "%" + cardEspecs.type + "%",
                "%" + cardEspecs.world + "%",
                "%" + cardEspecs.title + "%",
                "%" + cardEspecs.text + "%",
                "%" + cardEspecs.frequency + "%",
                "%" + cardEspecs.blueline + "%"
        };

        StringBuilder selectionBuilder = new StringBuilder();

        for (String column : CARD_COLUMNS_WHERE)
            selectionBuilder.append(column).append(" like ? OR");

        final String selection = selectionBuilder.toString();

        cursor = super.query(CARD_TABLE_NAME, CARD_COLUMNS, selection,
                selectionArgs, COLUMN_CINDEX);

        List<Card> cardsList = new ArrayList<>();

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                cardsList.add(cursorToEntity(cursor));
                cursor.moveToNext();
            }
            cursor.close();
        }

        return cardsList;
    }

    @Override
    protected Card cursorToEntity(Cursor cursor) {
        Card card = new Card();

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_CINDEX) != -1)
                card.cindex = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CINDEX));
            if (cursor.getColumnIndex(COLUMN_COLLECTION) != -1)
                card.collection = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_COLLECTION));
            if (cursor.getColumnIndex(COLUMN_NUMBER) != -1)
                card.number = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NUMBER));
            if (cursor.getColumnIndex(COLUMN_BONUS) != -1)
                card.bonus = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BONUS));
            if (cursor.getColumnIndex(COLUMN_TYPE) != -1)
                card.type = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE));
            if (cursor.getColumnIndex(COLUMN_WORLD) != -1)
                card.world = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_WORLD));
            if (cursor.getColumnIndex(COLUMN_TITLE) != -1)
                card.title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
            if (cursor.getColumnIndex(COLUMN_TEXT) != -1)
                card.text = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXT));
            if (cursor.getColumnIndex(COLUMN_FREQUENCY) != -1)
                card.frequency = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FREQUENCY));
            if (cursor.getColumnIndex(COLUMN_BLUELINE) != -1)
                card.blueline = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BLUELINE));
            if (cursor.getColumnIndex(COLUMN_AINDEX) != -1)
                card.aIndex = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_AINDEX));
            if (cursor.getColumnIndex(COLUMN_UINDEX) != -1)
                card.uIndex = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_UINDEX));
        }

        return card;
    }

    private ContentValues getContentValue() {
        return initialValues;
    }

    private void setContentValue(Card card) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_CINDEX, card.cindex);
        initialValues.put(COLUMN_COLLECTION, card.collection);
        initialValues.put(COLUMN_NUMBER, card.number);
        initialValues.put(COLUMN_BONUS, card.bonus);
        initialValues.put(COLUMN_TYPE, card.type);
        initialValues.put(COLUMN_WORLD, card.world);
        initialValues.put(COLUMN_TITLE, card.title);
        initialValues.put(COLUMN_TEXT, card.text);
        initialValues.put(COLUMN_FREQUENCY, card.frequency);
        initialValues.put(COLUMN_BLUELINE, card.blueline);
        initialValues.put(COLUMN_AINDEX, card.aIndex);
        initialValues.put(COLUMN_UINDEX, card.uIndex);
    }

    public Cursor getCursor() {
        return this.cursor;
    }
}
