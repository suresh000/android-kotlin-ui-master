package com.kotlin.ui.utils

import android.app.Activity
import android.content.Context
import android.graphics.Outline
import android.os.Build
import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

object AppUtil {

    val ERROR_DIALOG_REQUEST = 9001

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

    fun showToast(context: Context, message: String, length: Boolean) {
        Toast.makeText(context, message, if (length) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
    }

    fun showSnackbar(view: View, message: String, length: Boolean) {
        var snackbar: Snackbar? = null
        if (length) {
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        } else {
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        }
        snackbar.show()
    }

    fun isGoogleServicesOK(activity: Activity) : Boolean {
        val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(activity)

        if (available == ConnectionResult.SUCCESS) {
            return true
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            val dialog = GoogleApiAvailability.getInstance().getErrorDialog(activity, available, ERROR_DIALOG_REQUEST)
            dialog.show()
        }
        else {
            showToast(activity, "You can't make map request", true)
        }

        return false
    }

}