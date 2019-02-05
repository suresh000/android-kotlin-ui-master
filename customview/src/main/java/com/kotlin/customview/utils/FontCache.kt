package com.kotlin.customview.utils

import android.content.Context
import android.graphics.Typeface

object FontCache {

    private var openSansBold: Typeface? = null
    private var openSansBoldItalic: Typeface? = null
    private var openSansExtraBold: Typeface? = null
    private var openSansItalic: Typeface? = null
    private var openSansLight: Typeface? = null
    private var openSansRegular: Typeface? = null
    private var openSansSemiBold: Typeface? = null

    fun getOpenSansBoldFont(context: Context): Typeface {
        if (openSansBold == null) {
            openSansBold = Typeface.createFromAsset(
                context.resources
                    .assets, "fonts/OpenSans-Bold.ttf"
            )
        }
        return openSansBold!!
    }

    fun getOpenSansBoldItalicFont(context: Context): Typeface {
        if (openSansBoldItalic == null) {
            openSansBoldItalic = Typeface.createFromAsset(
                context.resources
                    .assets, "fonts/OpenSans-BoldItalic.ttf"
            )
        }
        return openSansBoldItalic!!
    }

    fun getOpenSansExtraBoldFont(context: Context): Typeface {
        if (openSansExtraBold == null) {
            openSansExtraBold = Typeface.createFromAsset(
                context.resources
                    .assets, "fonts/OpenSans-ExtraBold.ttf"
            )
        }
        return openSansExtraBold!!
    }

    fun getOpenSansItalicFont(context: Context): Typeface {
        if (openSansItalic == null) {
            openSansItalic = Typeface.createFromAsset(
                context.resources
                    .assets, "fonts/OpenSans-Italic.ttf"
            )
        }
        return openSansItalic!!
    }

    fun getOpenSansLightFont(context: Context): Typeface {
        if (openSansLight == null) {
            openSansLight = Typeface.createFromAsset(
                context.resources
                    .assets, "fonts/OpenSans-Light.ttf"
            )
        }
        return openSansLight!!
    }

    fun getOpenSansRegularFont(context: Context): Typeface {
        if (openSansRegular == null) {
            openSansRegular = Typeface.createFromAsset(
                context.resources
                    .assets, "fonts/OpenSans-Regular.ttf"
            )
        }
        return openSansRegular!!
    }

    fun getOpenSansSemiBoldFont(context: Context): Typeface {
        if (openSansSemiBold == null) {
            openSansSemiBold = Typeface.createFromAsset(
                context.resources
                    .assets, "fonts/OpenSans-Semibold.ttf"
            )
        }
        return openSansSemiBold!!
    }
}
