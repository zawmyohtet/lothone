package com.zawmyohtet.lothone.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.SimpleTimeZone;

public class DataStore extends SQLiteOpenHelper {

    private static final String TAG = "DataStore";

    private static final String DB_NAME = "lo_thone";
    private static final int DB_VERSION = 1;

    // Credential Table
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

    // Police Station
    public static final String TB_POLICE_STATION = "police_station";
    public static final String PL_ID = "id";
    public static final String PL_NAME = "name";
    public static final String PL_ADDRESS = "address";
    public static final String PL_TOWNSHIP = "township";
    public static final String PL_CITY = "city";
    public static final String PL_CONTACT = "contact";
    public static final String PL_LATITUDE = "latitude";
    public static final String PL_LONGITUDE = "longitude";

    // Fire
    public static final String TB_FIRE_STATION = "fire_station";
    public static final String FR_ID = "id";
    public static final String FR_NAME = "name";
    public static final String FR_ADDRESS = "address";
    public static final String FR_TOWNSHIP = "township";
    public static final String FR_CITY = "city";
    public static final String FR_CONTACT = "contact";
    public static final String FR_LATITUDE = "latitude";
    public static final String FR_LONGITUDE = "longitude";

    // Ambulance
    public static final String TB_AMBULANCE = "ambulance";
    public static final String AB_ID = "id";
    public static final String AB_NAME = "name";
    public static final String AB_ADDRESS = "address";
    public static final String AB_TOWNSHIP = "township";
    public static final String AB_CITY = "city";
    public static final String AB_CONTACT = "contact";
    public static final String AB_LATITUDE = "latitude";
    public static final String AB_LONGITUDE = "longitude";

    private int id;
    private String code, township, city, type;

    // Zip
    public static final String TB_ZIP = "zip";
    public static final String ZP_ID = "id";
    public static final String ZP_CODE = "code";
    public static final String ZP_TOWNSHIP = "township";
    public static final String ZP_CITY = "city";
    public static final String ZP_COUNTRY = "country";
    public static final String ZP_TYPE = "type";

    // Area
    public static final String TB_AREA = "area";
    public static final String AR_ID = "id";
    public static final String AR_CODE = "code";
    public static final String AR_TOWNSHIP = "township";
    public static final String AR_CITY = "city";
    public static final String AR_COUNTRY = "country";
    public static final String AR_TYPE = "type";


    public DataStore(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TB_USER + " (" +
            U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            U_NAME + " TEXT NULL, " +
            U_GENDER + " INTEGER NULL, " +
            U_BLOOD_TYPE + " INTEGER NULL, " +
            U_ADDRESS + " TEXT NULL, " +
            U_EMERGENCY_ONE + " TEXT NULL, " +
            U_EMERGENCY_TWO + " TEXT NULL, " +
            U_EMERGENCY_THREE + " TEXT NULL, " +
            U_CREATED_AT + " datetime NULL, " +
            U_UPDATED_AT + " datetime NULL);";

    private static final String CREATE_PS_TABLE = "CREATE TABLE " + TB_POLICE_STATION + " (" +
            PL_ID + " INTEGER PRIMARY KEY, " +
            PL_NAME + " TEXT NULL, " +
            PL_ADDRESS + " TEXT NULL, " +
            PL_TOWNSHIP + " TEXT NULL, " +
            PL_CITY + " TEXT NULL, " +
            PL_CONTACT + " TEXT NULL, " +
            PL_LATITUDE + " TEXT NULL, " +
            PL_LONGITUDE + " TEXT NULL);";

    private static final String CREATE_FR_TABLE = "CREATE TABLE " + TB_FIRE_STATION + " (" +
            FR_ID + " INTEGER PRIMARY KEY, " +
            FR_NAME + " TEXT NULL, " +
            FR_ADDRESS + " TEXT NULL, " +
            FR_TOWNSHIP + " TEXT NULL, " +
            FR_CITY + " TEXT NULL, " +
            FR_CONTACT + " TEXT NULL, " +
            FR_LATITUDE + " TEXT NULL, " +
            FR_LONGITUDE + " TEXT NULL);";

    private static final String CREATE_AB_TABLE = "CREATE TABLE " + TB_AMBULANCE + " (" +
            AB_ID + " INTEGER PRIMARY KEY, " +
            AB_NAME + " TEXT NULL, " +
            AB_ADDRESS + " TEXT NULL, " +
            AB_TOWNSHIP + " TEXT NULL, " +
            AB_CITY + " TEXT NULL, " +
            AB_CONTACT + " TEXT NULL, " +
            AB_LATITUDE + " TEXT NULL, " +
            AB_LONGITUDE + " TEXT NULL);";


    private static final String CREATE_ZP_TABLE = "CREATE TABLE " + TB_ZIP + " (" +
            ZP_ID + " INTEGER PRIMARY KEY, " +
            ZP_CODE + " TEXT NULL, " +
            ZP_TOWNSHIP + " TEXT NULL, " +
            ZP_CITY + " TEXT NULL, " +
            ZP_COUNTRY + " TEXT NULL, " +
            ZP_TYPE + " TEXT NULL);";

    private static final String CREATE_AR_TABLE = "CREATE TABLE " + TB_AREA + " (" +
            AR_ID + " INTEGER PRIMARY KEY, " +
            AR_CODE + " TEXT NULL, " +
            AR_TOWNSHIP + " TEXT NULL, " +
            AR_CITY + " TEXT NULL, " +
            AR_COUNTRY + " TEXT NULL, " +
            AR_TYPE + " TEXT NULL);";

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_USER_TABLE);
        database.execSQL(CREATE_PS_TABLE);
        database.execSQL(CREATE_FR_TABLE);
        database.execSQL(CREATE_AB_TABLE);
        database.execSQL(CREATE_ZP_TABLE);
        database.execSQL(CREATE_AR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
