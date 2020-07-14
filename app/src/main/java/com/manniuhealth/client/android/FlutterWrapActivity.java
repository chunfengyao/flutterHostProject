package com.manniuhealth.client.android;
/* * *
 * pkg name:     com.manniuhealth.client.android
 * created by:   yaochunfeng
 * on:           2020/6/17 14:43
 * Des:          Used to .
 * Email:        yaochunfeng@wondersgroup.com
 *
 * * */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.manniuhealth.client.android.constant.ConstantValues;
import com.manniuhealth.client.android.constant.FlutterRouteConstants;
import com.manniuhealth.client.android.tools.EngineUtils;

import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class FlutterWrapActivity extends AppCompatActivity {
    private FlutterView flutterView;
    private static String mRoutePath = FlutterRouteConstants.ROUTE_LOADING;

    public static void start(@NonNull Activity context, String routePath) {
        mRoutePath = routePath;
        context.startActivity(new Intent(context, FlutterWrapActivity.class));
        //推一个路由。
        EngineUtils.getGlobalCachedEngineForActivity(context).getNavigationChannel().pushRoute(mRoutePath);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flutter_wrap);
        flutterView = findViewById(R.id.flutterView);
        flutterView.attachToFlutterEngine(EngineUtils.getGlobalCachedEngineForActivity(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        {//resume flutterEngine
            EngineUtils.getGlobalCachedEngineForActivity(this).getLifecycleChannel().appIsResumed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //把路由推出去
        EngineUtils.getGlobalCachedEngineForActivity(ManniuApplication.getInstance()).getNavigationChannel().popRoute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        {//pause flutterEngine
            FlutterEngine flutterEngine;
            if ((flutterEngine = FlutterEngineCache.getInstance().get(ConstantValues.GLOBAL_FLUTTER_ENGINE)) != null) {
                flutterEngine.getLifecycleChannel().appIsPaused();
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        {//监听返回按钮，直接finish自己。
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
                //解除绑定
                flutterView.detachFromFlutterEngine();
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
