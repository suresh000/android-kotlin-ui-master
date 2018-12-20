package com.kotlin.ui.utils

import android.graphics.Outline
import android.os.Build
import android.view.View
import android.view.ViewOutlineProvider

object AppUtil {

    fun roundedOnlyTopCorner(view: View, curveRadius: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.outlineProvider = object : ViewOutlineProvider() {

                override fun getOutline(view: View?, outline: Outline?) {
                    outline!!.setRoundRect(0, 0, view!!.width, (view.height + curveRadius).toInt(), curveRadius)
                }

            }

            view.clipToOutline = true
        }
    }

}