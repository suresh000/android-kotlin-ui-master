package com.kotlin.customview.utils;

import android.content.Context;
import android.graphics.Typeface;

public class UIUtils {

    public static Typeface getFont(Context context, int mTextStyle) {
        switch (mTextStyle) {
            case 0:
                return FontCache.getOpenSansBoldFont(context);
            case 1:
                return FontCache.getOpenSansBoldItalicFont(context);
            case 2:
                return FontCache.getOpenSansExtraBoldFont(context);
            case 3:
                return FontCache.getOpenSansItalicFont(context);
            case 4:
                return FontCache.getOpenSansLightFont(context);
            case 5:
                return FontCache.getOpenSansRegularFont(context);
            case 6:
                return FontCache.getOpenSansSemiBoldFont(context);
            default:
                return FontCache.getOpenSansRegularFont(context);
        }
    }
}
