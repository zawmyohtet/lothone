package com.zawmyohtet.lothone.utility;

import android.content.ContentValues;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * @author zawmyohtet
 * @since 8/17/16
 */

public class Helper {

    private static final String TAG = "Helper";

    public static ContentValues convertToContentValues(JSONObject content) throws IllegalAccessException {

        Log.d(TAG, "Hello From converter -> " + content.toString());

        ContentValues cv = new ContentValues();

        try {

            Iterator keys = content.keys();

            while (keys.hasNext()) {

                String mKeys = (String) keys.next();

                Object value = content.get(mKeys.toString());

                if (value instanceof Integer) {
                    cv.put(mKeys, content.getInt(mKeys.toString()));
                }

                if (value instanceof String) {
                    cv.put(mKeys, content.getString(mKeys.toString()));
                }

                if (value instanceof Double) {
                    cv.put(mKeys, content.getDouble(mKeys.toString()));
                }

                if (value instanceof Long) {
                    cv.put(mKeys, content.getLong(mKeys.toString()));
                }

                if (value instanceof Boolean) {
                    cv.put(mKeys, content.getBoolean(mKeys.toString()));
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cv;
    }
}
