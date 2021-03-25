package com.dawn.community.utils.common;

import android.content.Context;

public class SizeUtils {

    public static int dip2px(Context context,Float dpValue){
        Float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }

}
