package com.zawmyohtet.lothone.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.zawmyohtet.lothone.receiver.ScreenOnOffReceiver;

public class EmergencyService extends Service {

    private static final String TAG = "EmergencyService";

    private int count = 0;
    private SharedPreferences mPref;

    public EmergencyService() {
        Log.d(TAG, "Start Emergency Service ... ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putInt("emergency_count", 0).apply();
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(CountReceiver, new IntentFilter(ScreenOnOffReceiver.NOTIFICATION));
        startCounter();
        return super.onStartCommand(intent, flags, startId);
    }

    private void startCounter() {
        int duration = Integer.valueOf(mPref.getString("listen_duration", "10000"));
        Log.d(TAG, "Duration -> " + duration);
        new CountDownTimer(duration, 1000) {
            public void onTick(long millisUntilFinished) {
//                Log.d(TAG, "Seconds remaining : " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Log.d(TAG, "Time to stop.");
                stopSelf();
            }
        }.start();
    }

    private BroadcastReceiver CountReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Receive from count receiver");
            count++;
            Log.d(TAG, "Here is my count -> " + count);
            if (count == Integer.valueOf(mPref.getString("start_action", "5"))) {
                Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator.hasVibrator()){
                    vibrator.vibrate(500);
                }
                stopSelf();
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(CountReceiver);
        Log.d(TAG, "Service stop -> ");
    }
}
