package com.manniuhealth.client.android.tools;
/* * *
 * pkg name:     com.manniuhealth.client.android.tools
 * created by:   yaochunfeng
 * on:           2020/6/17 21:04
 * Des:          Used to .
 * Email:        yaochunfeng@wondersgroup.com
 *
 * * */

import android.content.Context;

import com.manniuhealth.client.android.constant.ConstantValues;
import com.manniuhealth.client.android.constant.FlutterRouteConstants;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class EngineUtils {
    /**
     * 获取全局缓存的 FlutterEngine
     * @param context
     * @return
     */
    public static FlutterEngine getGlobalCachedEngineForActivity(Context context){
        FlutterEngine flutterEngine;
        if ((flutterEngine = FlutterEngineCache.getInstance().get(ConstantValues.GLOBAL_FLUTTER_ENGINE)) == null) {
            flutterEngine = new FlutterEngine(context);
            //这里使用路由地址作为engine名称标识。
            flutterEngine.getNavigationChannel().setInitialRoute(FlutterRouteConstants.ROUTE_LOADING);
            flutterEngine
                    .getDartExecutor()
                    .executeDartEntrypoint(
                            DartExecutor.DartEntrypoint
                                    .createDefault()
                    );
            FlutterEngineCache
                    .getInstance()
                    .put(ConstantValues.GLOBAL_FLUTTER_ENGINE, flutterEngine);
        }
        return flutterEngine;
    }
}
