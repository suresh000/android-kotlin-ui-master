package com.kotlin.ui.navigation

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.ui.R

class NavigationDrawerViewModel(private val mContext: Context, navRecyclerView: RecyclerView) {

    init {
        val navAdapter = NavigationDrawerAdapter(mContext, getNavList())
        navRecyclerView.adapter = navAdapter
        navRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }

    private fun getNavList(): List<NavigationDrawerItemViewModel> {
        val navList = ArrayList<NavigationDrawerItemViewModel>()

        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_home),
                mContext.resources.getString(R.string.nav_home)
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_home),
                mContext.resources.getString(R.string.nav_home)
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_home),
                mContext.resources.getString(R.string.nav_home)
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_home),
                mContext.resources.getString(R.string.nav_home)
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_home),
                mContext.resources.getString(R.string.nav_home)
            )
        )
        navList.add(
            NavigationDrawerItemViewModel(
                mContext.resources.getDrawable(R.drawable.ic_home),
                mContext.resources.getString(R.string.nav_home)
            )
        )

        return navList
    }

}