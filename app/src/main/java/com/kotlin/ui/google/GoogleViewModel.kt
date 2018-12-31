package com.kotlin.ui.google

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.databinding.ObservableField
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.kotlin.ui.utils.AppUtil
import com.kotlin.ui.utils.KeyboardUtils
import java.io.IOException

class GoogleViewModel(val context: Context, val activity: Activity, supportMapFragment: SupportMapFragment) {

    companion object {
        private const val DEFAULT_ZOOM = 15f
        private const val MY_LOCATION_TITLE = "My Location"
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
                        moveCamera(LatLng(currentLocation.latitude, currentLocation.longitude), DEFAULT_ZOOM, MY_LOCATION_TITLE)
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

    private fun moveCamera(latLng: LatLng, zoom: Float, title: String) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))

        if (!title.equals(MY_LOCATION_TITLE)) {
            val options = MarkerOptions().position(latLng).title(title)
            mMap.addMarker(options)
        }
    }

    fun getOnEditorActionListener() : TextView.OnEditorActionListener {
        return object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE) {
                    KeyboardUtils.hideKeyboard(activity)
                    geocoderSearchLocation()
                }

                return false
            }

        }
    }

    private fun geocoderSearchLocation() {
        val geocoder = Geocoder(context)
        var list = ArrayList<Address>()
        try {
            list = geocoder.getFromLocationName(searchText.get(), 1) as ArrayList<Address>
        }
        catch (e: IOException) {
            e.printStackTrace()
        }

        if (list.size > 0) {
            val address = list.get(0)
            moveCamera(LatLng(address.latitude, address.longitude), DEFAULT_ZOOM, address.getAddressLine(0))
        }
    }

}