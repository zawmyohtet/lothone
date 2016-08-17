package com.zawmyohtet.lothone.utility;

import android.content.ContentValues;
import android.util.Log;

import com.zawmyohtet.lothone.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import static com.google.android.gms.analytics.internal.zzy.i;
import static com.google.android.gms.analytics.internal.zzy.o;

/**
 * @author zawmyohtet
 * @since 8/17/16
 */

public class Helper {

    private static final String TAG = "Helper";

    public static ContentValues convertToContentValues(JSONObject content) throws IllegalAccessException{

        Log.d(TAG, "Hello From converter -> " + content.toString());

        ContentValues cv = new ContentValues();

        try {

            Iterator keys = content.keys();

            while (keys.hasNext()){

                String mKeys = (String) keys.next();

                Log.d(TAG, "Hello From Keys -> " + mKeys);

                Object value = content.get(mKeys.toString());

                if (value instanceof Integer){
                    cv.put(mKeys, content.getInt(mKeys.toString()));
                }

                if (value instanceof String){
                    cv.put(mKeys, content.getString(mKeys.toString()));
                }

                if (value instanceof Double){
                    cv.put(mKeys, content.getDouble(mKeys.toString()));
                }

                if (value instanceof Long){
                    cv.put(mKeys, content.getLong(mKeys.toString()));
                }

                if (value instanceof Boolean){
                    cv.put(mKeys, content.getBoolean(mKeys.toString()));
                }

            }

            JSONArray cKeys = content.names();

            for (int i = 0; i < cKeys.length(); i++){
                Log.d(TAG, "Hello From cKeys -> " + cKeys.get(i));

                Object value = content.get(cKeys.get(i).toString());

                if (value instanceof Integer){
                    cv.put(cKeys.get(i).toString(), content.getInt(cKeys.get(i).toString()));
                }

                if (value instanceof String){
                    cv.put(cKeys.get(i).toString(), content.getString(cKeys.get(i).toString()));
                }

                if (value instanceof Double){
                    cv.put(cKeys.get(i).toString(), content.getDouble(cKeys.get(i).toString()));
                }

                if (value instanceof Long){
                    cv.put(cKeys.get(i).toString(), content.getLong(cKeys.get(i).toString()));
                }

                if (value instanceof Boolean){
                    cv.put(cKeys.get(i).toString(), content.getBoolean(cKeys.get(i).toString()));
                }
            }


        } catch (JSONException e){
            e.printStackTrace();
        }

        return cv;
    }
}
