package com.example.boy.jiandemo;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * author：ZhouJian
 * date：2015/11/23 15:56
 * describe：线程转换
 */

public class ThreadUtils {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static Executor sExecutor = Executors.newSingleThreadExecutor();
    /**
     * 在子线程中运行一段任务
     * @param runnable
     */
    public static void runOnSubThread(Runnable runnable){
        sExecutor.execute(runnable);
    }

    /**
     * 在主线程中运行一段任务
     * @param runnable
     */
    public static void runOnMainThread(Runnable runnable){
        sHandler.post(runnable);
    }
}
