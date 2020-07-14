package com.manniuhealth.client.android;
/* * *
 * pkg name:     com.manniuhealth.client.android
 * created by:   yaochunfeng
 * on:           2020/6/16 10:42
 * Des:          Used to .
 * Email:        yaochunfeng@wondersgroup.com
 *
 * * */

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.manniuhealth.client.android.constant.ConstantValues;
import com.manniuhealth.client.android.constant.FlutterRouteConstants;

import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;


public class ManniuApplication extends Application {
    private static final String LOG_TAG = "ManniuApplication";

    public static ManniuApplication getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        SingletonHolder.INSTANCE = this;
        //创建全局缓存的engine
        new Handler().postAtFrontOfQueue(() -> {
            FlutterEngine flutterEngine = new FlutterEngine(this);
            //配置初始路由。
            flutterEngine.getNavigationChannel().setInitialRoute(FlutterRouteConstants.ROUTE_LOADING);
            //执行入口代码。
            flutterEngine
                    .getDartExecutor()
                    .executeDartEntrypoint(
                            DartExecutor.DartEntrypoint
                                    .createDefault()
                    );
            //放置到缓存池中去。
            FlutterEngineCache
                    .getInstance()
                    .put(ConstantValues.GLOBAL_FLUTTER_ENGINE, flutterEngine);
        });
        //创建全局缓存的engine(给另一个View用的)
        new Handler().postAtFrontOfQueue(() -> {
            FlutterEngine flutterEngine = new FlutterEngine(this);
            //配置初始路由。
            flutterEngine.getNavigationChannel().setInitialRoute(FlutterRouteConstants.ROUTE_LOADING);
            //执行入口代码。
            flutterEngine
                    .getDartExecutor()
                    .executeDartEntrypoint(
                            DartExecutor.DartEntrypoint
                                    .createDefault()
                    );
            //放置到缓存池中去。
            FlutterEngineCache
                    .getInstance()
                    .put(ConstantValues.GLOBAL_FLUTTER_ENGINE_FOR_CHILD_VIEW, flutterEngine);
        });
    }

    private static class SingletonHolder {
        private static ManniuApplication INSTANCE;
    }
}
