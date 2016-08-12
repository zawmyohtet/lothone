package com.zawmyohtet.lothone.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.WorkerThread;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.KeyEvent;

import com.zawmyohtet.lothone.services.EmergencyService;

/**
 * @author zawmyohtet
 * @since 8/12/16
 */

public class ScreenOnOffReceiver extends BroadcastReceiver {

    private static final String TAG = "ScreenOnOffReceiver";
    public static final String NOTIFICATION = "receiver.ScreenOnOffReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "Receive ...");

        if (intent != null) {

            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                // do whatever you need to do here
                Log.d(TAG, "Screen Off");
                publishResult(context);
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                if (!check(context, EmergencyService.class)) {
                    context.startService(new Intent(context, EmergencyService.class));
                }
                // and do whatever you need to do here
                Log.d(TAG, "Screen On");
                publishResult(context);
            }
        }
    }

    private void publishResult(Context context) {
        Intent intent = new Intent(NOTIFICATION);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @WorkerThread
    public static boolean check(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
