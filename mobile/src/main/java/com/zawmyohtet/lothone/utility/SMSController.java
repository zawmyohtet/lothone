package com.zawmyohtet.lothone.utility;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;

/**
 * @author zawmyohtet
 * @since 8/12/16
 */

public class SMSController {

    private static final String TAG = "SMSController";

    public void sendSMS(String phoneNumber, String message){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }

    public void readyToSendSMS(Context context, String phoneNumber, String message){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("smsto:"));
        i.setType("vnd.android-dir/mms-sms");
        i.putExtra("address", phoneNumber);
        i.putExtra("sms_body", message);

        try {
            context.startActivity(i);
        } catch (ActivityNotFoundException e){
            e.printStackTrace();
        }
    }
}
