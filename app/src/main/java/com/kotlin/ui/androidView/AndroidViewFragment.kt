package com.kotlin.ui.androidView


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.ui.R
import com.kotlin.ui.databinding.FragmentAndroidViewBinding

class AndroidViewFragment : Fragment() {

    private lateinit var mBinding: FragmentAndroidViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate<FragmentAndroidViewBinding>(inflater, R.layout.fragment_android_view, container, false)
        val vm = AndroidViewModel(context!!)
        mBinding.vm = vm
        return mBinding.root
    }


}
