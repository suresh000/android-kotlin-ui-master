package com.kotlin.ui.google

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.ui.R
import com.kotlin.ui.databinding.ActivityGoogleBinding
import com.kotlin.ui.utils.AppUtil

class GoogleActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityGoogleBinding
    private lateinit var mVm: GoogleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_google)
        mVm = GoogleViewModel()
        mBinding.vm = mVm

        AppUtil.roundedOnlyTopCorner(mBinding.parentConstraintLayout, 60F)
    }
}
