package com.manniuhealth.client.android;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.manniuhealth.client.android.constant.ConstantValues;

import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class MainActivity extends AppCompatActivity {
    private Button startNewFlutterPageBtn;
    private Button startNewFlutterPageSecondBtn;
    private Button createNewFlutterViewBtn;
    private LinearLayout flutterFragContainer;
    private FlutterView flutterViewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNewFlutterPageBtn = findViewById(R.id.startNewFlutterPageBtn);
        startNewFlutterPageSecondBtn = findViewById(R.id.startNewFlutterPageSecondBtn);
        createNewFlutterViewBtn = findViewById(R.id.createNewFlutterViewBtn);
        flutterFragContainer = findViewById(R.id.flutterFragContainer);
        flutterViewContainer = findViewById(R.id.flutterViewContainer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //加回点击。
        startNewFlutterPageBtn.setClickable(true);
        startNewFlutterPageSecondBtn.setClickable(true);
    }

    /**
     * 点击事件
     * @param view
     */
    @Keep
    public void startNewFlutterPageBtnClick(View view){
        //取消点击。
        startNewFlutterPageBtn.setClickable(false);
        FlutterWrapActivity.start(this, "/home");
    }

    /**
     * 点击事件
     * @param view
     */
    @Keep
    public void startNewFlutterPageSecondBtnClick(View view){
        //取消点击。
        startNewFlutterPageSecondBtn.setClickable(false);
        FlutterWrapActivity.start(this, "/secondPage");
//        startActivity(FlutterFragmentActivity.withCachedEngine(ConstantValues.GLOBAL_FLUTTER_ENGINE)
//                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
//                .build(this));
//        FlutterWrapActivity.getGlobalCachedEngineForActivity(this).getNavigationChannel().pushRoute("/secondPage");
    }

    /**
     * 点击事件
     * @param view
     */
    @Keep
    public void createNewFlutterFragBtnClick(View view){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flutterFragContainer, new FlutterDemoFrag())
                .commit();
    }

    /**
     * 点击事件
     * @param view
     */
    @Keep
    public void createNewFlutterViewBtnClick(View view){
        FlutterEngine flutterEngine;
        if ((flutterEngine = FlutterEngineCache.getInstance().get(ConstantValues.GLOBAL_FLUTTER_ENGINE_FOR_CHILD_VIEW)) != null) {
            flutterViewContainer.attachToFlutterEngine(flutterEngine);
            flutterEngine.getLifecycleChannel().appIsResumed();
        }else {
            flutterEngine = new FlutterEngine(this);
            //这里使用路由地址作为engine名称标识。
            flutterEngine.getNavigationChannel().setInitialRoute("/child");
            flutterEngine
                    .getDartExecutor()
                    .executeDartEntrypoint(
                            DartExecutor.DartEntrypoint
                                    .createDefault()
                    );
            FlutterEngineCache
                    .getInstance()
                    .put(ConstantValues.GLOBAL_FLUTTER_ENGINE_FOR_CHILD_VIEW, flutterEngine);
            flutterViewContainer.attachToFlutterEngine(flutterEngine);
            flutterEngine.getLifecycleChannel().appIsResumed();
        }
    }

}