package com.kotlin.ui.google

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.ObservableField
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.kotlin.ui.utils.AppUtil

class GoogleViewModel(val context: Context, supportMapFragment: SupportMapFragment) {

    companion object {
        private val DEFAULT_ZOOM = 15f
    }

    val searchText = ObservableField<String>()

    private lateinit var mMap: GoogleMap
    private lateinit var mFusedLocationProviderClient: FusedLocationProviderClient

    init {
        supportMapFragment.getMapAsync(object : OnMapReadyCallback {

            @SuppressLint("MissingPermission")
            override fun onMapReady(googleMap: GoogleMap?) {
                AppUtil.showToast(context, "Map is Ready", true)
                mMap = googleMap!!
                getCurrentLocation()

                mMap.isMyLocationEnabled = true
            }

        })
    }

    private fun getCurrentLocation() {
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        try {
            val location = mFusedLocationProviderClient.lastLocation
            location.addOnCompleteListener(object : OnCompleteListener<Location> {
                override fun onComplete(task: Task<Location>) {
                    if (task.isSuccessful) {
                        val currentLocation = task.result as Location
                        moveCamera(LatLng(currentLocation.latitude, currentLocation.longitude), DEFAULT_ZOOM)
                    }
                    else {
                        AppUtil.showToast(context, "unable to get current location", true)
                    }
                }

            })
        }
        catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    private fun moveCamera(latLng: LatLng, zoom: Float) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
    }

}