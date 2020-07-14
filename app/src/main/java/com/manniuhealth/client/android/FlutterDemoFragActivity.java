package com.manniuhealth.client.android;
/* * *
 * pkg name:     com.manniuhealth.client.android.constant
 * created by:   yaochunfeng
 * on:           2020/6/17 20:39
 * Des:          Used to .
 * Email:        yaochunfeng@wondersgroup.com
 *
 * * */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.manniuhealth.client.android.constant.FlutterRouteConstants;

class FlutterDemoFragActivity extends AppCompatActivity {

    private static String mRoutePath = FlutterRouteConstants.ROUTE_LOADING;

    public static void start(@NonNull Activity context, String routePath) {
        mRoutePath = routePath;
        context.startActivity(new Intent(context, FlutterDemoFragActivity.class));
    }

    View fragFlutterView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_activity_flutter_wrap);
        fragFlutterView = findViewById(R.id.fragFlutterView);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragFlutterView, new FlutterDemoFrag());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        {//监听返回按钮，直接finish自己。
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
