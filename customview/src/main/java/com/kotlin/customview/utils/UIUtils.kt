package com.kotlin.customview.utils

import android.content.Context
import android.graphics.Typeface

object UIUtils {

    fun getFont(context: Context, mTextStyle: Int): Typeface {
        return when (mTextStyle) {
            0 -> FontCache.getOpenSansBoldFont(context)
            1 -> FontCache.getOpenSansBoldItalicFont(context)
            2 -> FontCache.getOpenSansExtraBoldFont(context)
            3 -> FontCache.getOpenSansItalicFont(context)
            4 -> FontCache.getOpenSansLightFont(context)
            5 -> FontCache.getOpenSansRegularFont(context)
            6 -> FontCache.getOpenSansSemiBoldFont(context)
            else -> FontCache.getOpenSansRegularFont(context)
        }
    }
}
