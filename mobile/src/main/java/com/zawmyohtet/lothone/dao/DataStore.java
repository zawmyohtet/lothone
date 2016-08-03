package com.zawmyohtet.lothone.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.SimpleTimeZone;

public class DataStore extends SQLiteOpenHelper {

    private static final String TAG = "DataStore";

    private static final String DB_NAME = "lo_thone";
    private static final int DB_VERSION = 1;

    // User Table
    public static final String TB_USER = "user";
    public static final String U_ID = "id";
    public static final String U_NAME = "name";
    public static final String U_GENDER = "gender";
    public static final String U_BLOOD_TYPE = "blood_type";
    public static final String U_ADDRESS = "address";
    public static final String U_EMERGENCY_ONE = "emergency_contact_one";
    public static final String U_EMERGENCY_TWO = "emergency_contact_two";
    public static final String U_EMERGENCY_THREE = "emergency_contact_three";
    public static final String U_CREATED_AT = "created_at";
    public static final String U_UPDATED_AT = "updated_at";

    public DataStore(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TB_USER + " (" +
            U_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
            U_NAME + "TEXT NULL, " +
            U_GENDER + "TEXT NULL, " +
            U_BLOOD_TYPE + "TEXT NULL, " +
            U_ADDRESS + "TEXT NULL, " +
            U_EMERGENCY_ONE + "TEXT NULL, " +
            U_EMERGENCY_TWO + "TEXT NULL, " +
            U_EMERGENCY_THREE + "TEXT NULL, " +
            U_CREATED_AT + " datetime NULL, " +
            U_UPDATED_AT + " datetime NULL);";

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
