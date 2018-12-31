package com.kotlin.ui.google

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.SupportMapFragment
import com.kotlin.ui.R
import com.kotlin.ui.databinding.ActivityGoogleBinding
import com.kotlin.ui.utils.AppUtil

class GoogleActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityGoogleBinding
    private lateinit var mVm: GoogleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_google)
        val suppoerMapFragment = getSupportFragmentManager().findFragmentById(R.id.map) as SupportMapFragment
        mVm = GoogleViewModel(this, this, suppoerMapFragment)
        mBinding.vm = mVm

        AppUtil.roundedOnlyTopCorner(mBinding.parentConstraintLayout, 60F)
    }
}
