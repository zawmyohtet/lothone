package com.zawmyohtet.lothone.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.zawmyohtet.lothone.model.User;
import com.zawmyohtet.lothone.receiver.ScreenOnOffReceiver;
import com.zawmyohtet.lothone.utility.Ability;
import com.zawmyohtet.lothone.utility.Credential;
import com.zawmyohtet.lothone.utility.SMSController;

public class EmergencyService extends Service implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final String TAG = "EmergencyService";
    private static final long[] pattern = {0, 300, 100, 300};

    private int count = 0;
    private SharedPreferences mPref;
    private GoogleApiClient mGoogleApiClient;
    private Vibrator vibrator;
    private Location mLastLocation;

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
        // Create an instance of GoogleAPIClient.
        vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mGoogleApiClient.connect();

        mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putInt("emergency_count", 0).apply();

        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(CountReceiver, new IntentFilter(ScreenOnOffReceiver.NOTIFICATION));

        startCounter();

        return super.onStartCommand(intent, flags, startId);
    }

    private void startCounter() {
        // Notify user
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(300);
        }

        int duration = Integer.valueOf(mPref.getString("listen_duration", "10000"));

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

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        try {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

            if (mLastLocation != null) {
                Log.d(TAG, "Lat -> " + mLastLocation.getLatitude());
                Log.d(TAG, "Long -> " + mLastLocation.getLongitude());
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "Location changed -> ");
        mLastLocation = location;
    }

    private BroadcastReceiver CountReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Receive from count receiver");
            count++;
            Log.d(TAG, "Here is my count -> " + count);
            if (count == Integer.valueOf(mPref.getString("start_action", "5"))) {
                if (vibrator.hasVibrator()) {
                    vibrator.vibrate(pattern, -1);
                }
                stopSelf();
            }
        }
    };

    private void alert() {
        Context context = getApplicationContext();
        User user = Credential.getInstance(context).getActiveUser();
        SMSController smsController = new SMSController();

        if (user != null) {

            String[] phoneNumbers = {user.getEmergencyNumberOne(), user.getEmergencyNumberTwo(), user.getEmergencyNumberThree()};

            if (new Ability().hasTelephony(context)) {

                for (int i = 0; i < 3; i++) {

                    if (phoneNumbers[i] != null){
                        smsController.sendSMS(phoneNumbers[i], "Hello");
                    }

                }

            }

        }
        stopSelf();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(CountReceiver);
        Log.d(TAG, "Service stop -> ");
    }
}
