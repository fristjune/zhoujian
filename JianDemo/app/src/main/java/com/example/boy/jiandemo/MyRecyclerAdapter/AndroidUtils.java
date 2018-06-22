package com.example.boy.jiandemo.MyRecyclerAdapter;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Description Android工具
 */
public class AndroidUtils {

    /**
     * 获取屏幕的宽度 <br/>
     *
     * @param [cx]-[上下文对象] <br/>
     * @return 屏幕宽度（单位px）
     */
    public static float getDeviceWidth(Context cx) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 将dp值转换为px值，保证文字大小不变
     *
     * @param cx
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param cx
     * @param spValue
     * @return
     */
    public static int sp2px(Context cx, float spValue) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return (int) (spValue * dm.scaledDensity + 0.5f);
    }
}
