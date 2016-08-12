package com.zawmyohtet.lothone.utility;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

/**
 * @author zawmyohtet
 * @since 8/12/16
 */

public class Caller {

    private static final String TAG = "Caller";

    public static final String NUMBER_TO_CALL = "number";

    /**
     * It will try to make call depend on preference
     * @param context
     * @param number
     */
    public void make(Context context, String number) {

        SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(context);

        if (mPref.getBoolean("direct_call", false)) {
            this.call(context, number);
        } else {
            this.prepare(context, number);
        }

    }

    /**
     * Direct call
     * @param context
     * @param number
     */
    public void call(Context context, String number) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            context.startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prepare call
     * @param context
     * @param number
     */
    public void prepare(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        context.startActivity(intent);
    }
}
