package com.zawmyohtet.lothone.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.view.KeyEvent;

import com.zawmyohtet.lothone.receiver.ScreenOnOffReceiver;

public class LothoneService extends Service {

    private static final String TAG = "LothoneService";


    public LothoneService() {
        Log.d(TAG, "Service init");
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
        final IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        registerReceiver(new ScreenOnOffReceiver(), filter);
        return super.onStartCommand(intent, flags, startId);
    }

}
