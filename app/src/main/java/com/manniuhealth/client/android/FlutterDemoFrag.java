package com.manniuhealth.client.android;
/* * *
 * pkg name:     com.manniuhealth.client.android
 * created by:   yaochunfeng
 * on:           2020/6/15 18:51
 * Des:          Used to .
 * Email:        yaochunfeng@wondersgroup.com
 *
 * * */

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.manniuhealth.client.android.constant.ConstantValues;
import com.manniuhealth.client.android.constant.FlutterRouteConstants;
import com.manniuhealth.client.android.tools.EngineUtils;

import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.TransparencyMode;

public class FlutterDemoFrag extends FlutterFragment {
    public FlutterDemoFrag() {
        withNewEngine()
                .initialRoute(FlutterRouteConstants.ROUTE_TRANSPARENT_LOADING);
    }

    @Override
    public void onAttach(@NonNull Context context) {
//        EngineUtils.getGlobalCachedEngineForActivity(context)
//                .getNavigationChannel()
//                .pushRoute(FlutterRouteConstants.ROUTE_TRANSPARENT_LOADING);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDetach() {
//        EngineUtils.getGlobalCachedEngineForActivity(getActivity())
//                .getNavigationChannel()
//                .popRoute();
        super.onDetach();
    }
}
