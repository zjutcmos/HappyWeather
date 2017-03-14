package com.cmos.happyweather.application;

import com.tencent.bugly.crashreport.CrashReport;

import org.litepal.LitePalApplication;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public class MyApplication extends LitePalApplication{
    @Override
    public void onCreate() {
        CrashReport.initCrashReport(getApplicationContext(), "a4a3a901fd", true);
        super.onCreate();
    }
}
