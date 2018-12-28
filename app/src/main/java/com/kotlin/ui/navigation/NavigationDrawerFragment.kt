package com.kotlin.ui.navigation

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.ui.R
import com.kotlin.ui.databinding.FragmentNavigationDrawerBinding

class NavigationDrawerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNavigationDrawerBinding>(
            inflater,
            R.layout.fragment_navigation_drawer, container, false
        )
        val vm = NavigationDrawerViewModel(context!!, binding.navRecyclerView)
        binding.vm = vm

        return binding.root
    }
}