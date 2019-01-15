package com.kotlin.ui.bottomNavigation.store


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.ui.R
import com.kotlin.ui.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private lateinit var mBinding: FragmentStoreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)

        return mBinding.root
    }


}
