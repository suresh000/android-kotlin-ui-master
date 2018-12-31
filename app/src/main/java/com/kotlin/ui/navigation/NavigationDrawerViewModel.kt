package com.kotlin.ui.navigation

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.ui.R
import android.arch.lifecycle.ViewModel



class NavigationDrawerViewModel(private val mContext: Context, navRecyclerView: RecyclerView, private val mNavigationCallback: NavigationDrawerFragment.NavigationDrawerCallback) {

    private val onNavigationItemSelection = object : OnNavigationItemSelection {

        override fun onSelected(type: NavigationViewType) {
            mNavigationCallback.onNavigationDrawerItemSelected(type)
        }

    }

    init {
        val navAdapter = NavigationDrawerAdapter(mContext, getNavList())
        navRecyclerView.adapter = navAdapter
        navRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }

    private fun getNavList(): List<NavigationDrawerItemViewModel> {
        val navList = ArrayList<NavigationDrawerItemViewModel>()

        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_nav_home),
                mContext.resources.getString(R.string.nav_home),
                NavigationViewType.HOME,
                onNavigationItemSelection
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_nav_google),
                mContext.resources.getString(R.string.nav_google),
                NavigationViewType.GOOGLE,
                onNavigationItemSelection
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_nav_support),
                mContext.resources.getString(R.string.nav_support),
                NavigationViewType.PROFILE,
                onNavigationItemSelection
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_nav_about),
                mContext.resources.getString(R.string.nav_about),
                NavigationViewType.ABOUT_US,
                onNavigationItemSelection
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_nav_logout),
                mContext.resources.getString(R.string.nav_logout),
                NavigationViewType.LOGOUT,
                onNavigationItemSelection
            )
        )

        return navList
    }

    interface OnNavigationItemSelection {
        fun onSelected(type: NavigationViewType)
    }

}