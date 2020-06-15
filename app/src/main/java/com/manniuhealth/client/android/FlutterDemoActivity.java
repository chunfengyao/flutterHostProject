package com.manniuhealth.client.android;
/* * *
 * pkg name:     com.manniuhealth.client.android
 * created by:   yaochunfeng
 * on:           2020/6/15 18:46
 * Des:          Used to .
 * Email:        yaochunfeng@wondersgroup.com
 *
 * * */

import android.app.Activity;

import androidx.annotation.NonNull;

public class FlutterDemoActivity extends io.flutter.embedding.android.FlutterActivity {

    public static void start(@NonNull Activity context){
        context.startActivity(createDefaultIntent(context));
    }

}
