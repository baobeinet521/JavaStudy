package com.study.android;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyApplication extends Application {
    private final static String TAG = "MyApplication";

    private static MyApplication instance = null;
    private RefWatcher refWatcher;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // LeakCanary创建
        refWatcher = setupLeakCanary();
        instance = this;
        Log.d(TAG, "MyApplication, onCreate: ---------------");
    }

    /**
     * 设置setupLeakCanary
     *
     * @return
     */
    private RefWatcher setupLeakCanary() {
        // enabledStrictMode();  // 启用严格模式
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    /**
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        MyApplication leakApplication = (MyApplication) context.getApplicationContext();
        return leakApplication.refWatcher;
    }

    private static void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }
}
