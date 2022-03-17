package com.example.ppc_tpfinalcursada_kowalski_fargnoli;

import android.app.Application;
import android.content.Context;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

public class MyApplication extends Application {
    private static MyApplication mInstance;
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        this.setAppContext(getApplicationContext());
    }

    public static MyApplication getInstance(MainActivity5 mainActivity5){
        return mInstance;
    }
    public static Context getAppContext() {
        return mAppContext;
    }
    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }

}
