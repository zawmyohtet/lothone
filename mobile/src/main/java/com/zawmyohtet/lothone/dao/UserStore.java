package com.zawmyohtet.lothone.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zawmyohtet.lothone.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author zawmyohtet
 * @since 8/3/16
 */

public class UserStore {

    private static final String TAG = "UserStore";
    private SQLiteDatabase database;
    private DataStore dataStore;
    private SimpleDateFormat dateFormat;

    public UserStore(Context context) {
        dataStore = new DataStore(context);
        dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH);
    }

    public void open() {
        database = dataStore.getWritableDatabase();
    }

    public void close() {
        dataStore.close();
    }

    /**
     * Public method to create or update user
     * @param user
     * @return id
     */
    public long push(User user) {
        long id = -1;

        open();

        Date date = new Date();
        ContentValues values = new ContentValues();
        values.put(DataStore.U_ID, 1);
        values.put(DataStore.U_NAME, user.getName());
        values.put(DataStore.U_GENDER, user.getGender());
        values.put(DataStore.U_BLOOD_TYPE, user.getBloodType());
        values.put(DataStore.U_ADDRESS, user.getAddress());
        values.put(DataStore.U_EMERGENCY_ONE, user.getEmergencyNumberOne());
        values.put(DataStore.U_EMERGENCY_TWO, user.getEmergencyNumberTwo());
        values.put(DataStore.U_EMERGENCY_THREE, user.getEmergencyNumberThree());

        if (user.getCreatedAt() == null){
            values.put(DataStore.U_CREATED_AT, dateFormat.format(date));
        }

        values.put(DataStore.U_UPDATED_AT, dateFormat.format(date));

        try {

            id = database.replace(DataStore.TB_USER, DataStore.U_ID + "=" + 1, values);

        } catch (Exception e) {
            e.printStackTrace();
        }

        close();
        return id;
    }

    /**
     * Public method to fetch user data
     * @return Credential
     */
    public User pull() {
        open();
        User user = new User();
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM " + DataStore.TB_USER + " LIMIT 1", null);

            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()){
                    do {
                        user.setId(cursor.getInt(0));
                        user.setName(cursor.getString(1));
                        user.setGender(cursor.getInt(2));
                        user.setBloodType(cursor.getInt(3));
                        user.setAddress(cursor.getString(4));
                        user.setEmergencyNumberOne(cursor.getString(5));
                        user.setEmergencyNumberTwo(cursor.getString(6));
                        user.setEmergencyNumberThree(cursor.getString(7));
                        user.setCreatedAt(cursor.getString(8));
                        user.setUpdatedAt(cursor.getString(9));
                    } while (cursor.moveToNext());
                }
            }

            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        close();

        return user;
    }
}




























