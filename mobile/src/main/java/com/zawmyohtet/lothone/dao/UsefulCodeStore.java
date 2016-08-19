package com.zawmyohtet.lothone.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.zawmyohtet.lothone.model.UsefulCode;

import java.util.ArrayList;

/**
 * @author zawmyohtet
 * @since 8/19/16
 */

public class UsefulCodeStore {

    private static final String TAG = "UsefulCodeStore";

    public static final int TYPE_ZIP = 1;
    public static final int TYPE_AREA = 2;

    private SQLiteDatabase database;
    private DataStore dataStore;

    public UsefulCodeStore(Context context) {
        dataStore = new DataStore(context);
    }

    public void open() {
        database = dataStore.getWritableDatabase();
    }

    public void close() {
        dataStore.close();
    }

    public long push(int type, ContentValues contentValues){
        long id = -1;

        String table = this.getTable(type);

        try {
            open();

            id = database.replace(table, null, contentValues);

            close();

        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        return id;
    }

    public ArrayList<UsefulCode> pull(int type) {

        ArrayList<UsefulCode> usefulCodes = new ArrayList<>();

        String table = this.getTable(type);

        open();

        try {

            Cursor cursor = database.rawQuery("SELECT * FROM " + table, null);

            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    do {

                        usefulCodes.add(new UsefulCode(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), table));

                    } while (cursor.moveToNext());
                }
            }
                cursor.close();

            } catch (SQLiteException e) {
                e.printStackTrace();
            }

            close();

            return usefulCodes;
        }

    private String getTable(int type){
        String table = DataStore.TB_ZIP;

        switch (type) {
            case 1:
                table = DataStore.TB_ZIP;
                break;
            case 2:
                table = DataStore.TB_AREA;
                break;
        }

        return table;
    }

}
