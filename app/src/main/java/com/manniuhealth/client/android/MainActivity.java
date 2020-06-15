package com.manniuhealth.client.android;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button startNewFlutterPageBtn;
    private Button createNewFlutterViewBtn;
    private LinearLayout flutterViewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNewFlutterPageBtn = findViewById(R.id.startNewFlutterPageBtn);
        createNewFlutterViewBtn = findViewById(R.id.createNewFlutterViewBtn);
        flutterViewContainer = findViewById(R.id.flutterViewContainer);

    }

    /**
     * 点击事件
     * @param view
     */
    @Keep
    public void startNewFlutterPageBtnClick(View view){
        FlutterDemoActivity.start(this);
    }

    /**
     * 点击事件
     * @param view
     */
    @Keep
    public void createNewFlutterViewBtnClick(View view){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flutterViewContainer, new FlutterDemoFrag())
                .commit();
    }

}