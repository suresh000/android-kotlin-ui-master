package com.kotlin.ui.navigation

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.ui.R
import com.kotlin.ui.databinding.FragmentNavigationDrawerBinding


class NavigationDrawerFragment : Fragment() {

    private lateinit var mNavigationCallback: NavigationDrawerCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNavigationDrawerBinding>(
            inflater,
            R.layout.fragment_navigation_drawer, container, false
        )
        val vm = NavigationDrawerViewModel(context!!, binding.navRecyclerView, mNavigationCallback)
        binding.vm = vm

        return binding.root
    }

    override fun onAttach(activity: Context) {
        super.onAttach(activity)
        try {
            mNavigationCallback = activity as NavigationDrawerCallback
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "Activity must implement NavigationDrawerCallback."
            )
        }

    }

    interface NavigationDrawerCallback {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        fun onNavigationDrawerItemSelected(type: NavigationViewType)
    }
}