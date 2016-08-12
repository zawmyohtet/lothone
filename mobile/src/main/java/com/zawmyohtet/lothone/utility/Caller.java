package com.zawmyohtet.lothone.utility;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

/**
 * @author zawmyohtet
 * @since 8/12/16
 */

public class Caller {

    private static final String TAG = "Caller";

    public static final String NUMBER_TO_CALL = "number";

    /**
     * It will try to make call depend on preference
     *
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
     *
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
     *
     * @param context
     * @param number
     */
    public void prepare(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        context.startActivity(intent);
    }

    /**
     * Credit: http://www.journaldev.com/641/regular-expression-phone-number-validation-in-java
     * @param number
     * @return
     */
    public boolean checkNumber(String number) {
        //validate phone numbers of format "1234567890"
        if (number.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if (number.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if (number.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if (number.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;
    }
}
