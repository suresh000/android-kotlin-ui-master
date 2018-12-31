package com.kotlin.ui.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

object AppPermissionUtil {

    val LOCATION_PERMISSION_REQUEST_CODE = 1234

    val FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
    val COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION

    fun isLocationPermissionAllow(activity: Activity) : Boolean {
        val permissions = arrayOf(FINE_LOCATION, COARSE_LOCATION)
        if (ContextCompat.checkSelfPermission(activity.applicationContext, FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(activity.applicationContext, COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true
        }
        else {
            ActivityCompat.requestPermissions(activity, permissions, LOCATION_PERMISSION_REQUEST_CODE)
        }

        return false
    }

}