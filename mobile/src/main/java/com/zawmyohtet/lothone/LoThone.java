package com.zawmyohtet.lothone;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * @author zawmyohtet
 * @since 7/28/16
 */

public class LoThone extends Application {

    private static final String TAG = "LoThone";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
