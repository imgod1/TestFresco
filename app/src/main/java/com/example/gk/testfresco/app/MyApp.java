package com.example.gk.testfresco.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 项目名称：TestFresco
 * 类描述：
 * 创建人：gk
 * 创建时间：2016/8/23 15:33
 * 修改人：gk
 * 修改时间：2016/8/23 15:33
 * 修改备注：
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initAllSdk();
    }

    private void initAllSdk() {
        Fresco.initialize(this);//初始化Fresco
    }
}
