package com.zawmyohtet.lothone.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.zawmyohtet.lothone.model.EmergencyContact;

import java.util.ArrayList;


/**
 * @author zawmyohtet
 * @since 8/18/16
 */

public class EmergencyContactStore {

    private static final String TAG = "EmergencyContactStore";

    public static final int TYPE_POLICE_STATION = 1;
    public static final int TYPE_FIRE_STATION = 2;
    public static final int TYPE_AMBULANCE = 3;

    private DataStore dataStore;
    private SQLiteDatabase database;

    public EmergencyContactStore(Context context) {
        dataStore = new DataStore(context);
    }

    public void open() {
        database = dataStore.getWritableDatabase();
    }

    public void close() {
        dataStore.close();
    }

    public long push(int type, ContentValues values) {

        long id = -1;
        String table = DataStore.TB_POLICE_STATION;

        switch (type) {
            case 1:
                table = DataStore.TB_POLICE_STATION;
                break;
            case 2:
                table = DataStore.TB_FIRE_STATION;
                break;
            case 3:
                table = DataStore.TB_AMBULANCE;
                break;
        }

        try {
            open();

            id = database.replace(table, null, values);

            Cursor cursor = database.rawQuery("SELECT * FROM " + DataStore.TB_POLICE_STATION, null);

            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    do {
                        Log.d(TAG, "It is name -> " + cursor.getString(0) + cursor.getString(1) + cursor.getString(2) + cursor.getString(3) + cursor.getString(4) + cursor.getString(5) + cursor.getString(6) + cursor.getString(7));
                    } while (cursor.moveToNext());
                }
            }

            close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public ArrayList<EmergencyContact> pull(){

        ArrayList<EmergencyContact> emergencyContacts = new ArrayList<>();

        open();

//            try {
//
//            } catch ()

        close();

        return emergencyContacts;
    }

}
