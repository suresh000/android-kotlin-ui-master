package com.kotlin.customview.utils;

import android.content.Context;
import android.graphics.Typeface;

public class FontCache {

    private static Typeface openSansBold, openSansBoldItalic, openSansExtraBold, openSansItalic, openSansLight, openSansRegular, openSansSemiBold;

    public static Typeface getOpenSansBoldFont(Context context) {
        if (openSansBold == null) {
            openSansBold = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/OpenSans-Bold.ttf");
        }
        return openSansBold;
    }

    public static Typeface getOpenSansBoldItalicFont(Context context) {
        if (openSansBoldItalic == null) {
            openSansBoldItalic = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/OpenSans-BoldItalic.ttf");
        }
        return openSansBoldItalic;
    }

    public static Typeface getOpenSansExtraBoldFont(Context context) {
        if (openSansExtraBold == null) {
            openSansExtraBold = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/OpenSans-ExtraBold.ttf");
        }
        return openSansExtraBold;
    }

    public static Typeface getOpenSansItalicFont(Context context) {
        if (openSansItalic == null) {
            openSansItalic = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/OpenSans-Italic.ttf");
        }
        return openSansItalic;
    }

    public static Typeface getOpenSansLightFont(Context context) {
        if (openSansLight == null) {
            openSansLight = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/OpenSans-Light.ttf");
        }
        return openSansLight;
    }

    public static Typeface getOpenSansRegularFont(Context context) {
        if (openSansRegular == null) {
            openSansRegular = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/OpenSans-Regular.ttf");
        }
        return openSansRegular;
    }

    public static Typeface getOpenSansSemiBoldFont(Context context) {
        if (openSansSemiBold == null) {
            openSansSemiBold = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/OpenSans-Semibold.ttf");
        }
        return openSansSemiBold;
    }
}
