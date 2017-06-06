package br.com.gilsouza.spellfiredeckbuilder.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import br.com.gilsouza.spellfiredeckbuilder.dao.CardDAO;

/**
 * Created by gilmar on 04/06/17.
 */

public class Database {
    private static final String TAG = "Spellfire_Database";
    private static final String DATABASE_NAME = "newSpellfire.sqlite";
    // Increment DB Version on any schema change
    private static final int DATABASE_VERSION = 1;
    public static CardDAO mCardDao;
    private final Context mContext;
    private DatabaseOpenHelper mDbHelper;

    public Database(Context context) {
        this.mContext = context;
    }

    public Database open() throws SQLException {
        mDbHelper = new DatabaseOpenHelper(mContext);
        SQLiteDatabase mDb = mDbHelper.getWritableDatabase();

        mCardDao = new CardDAO(mDb);

        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    //    private static class DatabaseHelper extends SQLiteOpenHelper {
//        DatabaseHelper(Context context) {
//            super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        }
//
//        @Override
//        public void onCreate(SQLiteDatabase db) {
////            db.execSQL(IUserSchema.USER_TABLE_CREATE);
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion,
//                              int newVersion) {
//            Log.w(TAG, "Upgrading database from version "
//                    + oldVersion + " to "
//                    + newVersion + " which destroys all old data");
//
////            db.execSQL("DROP TABLE IF EXISTS "
////                    + IUserSchema.USER_TABLE);
////            onCreate(db);
//
//        }
//    }
    private static class DatabaseOpenHelper extends SQLiteAssetHelper {


        public DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
    }

}
