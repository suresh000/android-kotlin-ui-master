package com.kotlin.ui.dashboard

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.kotlin.ui.BaseActivity
import com.kotlin.ui.R
import com.kotlin.ui.databinding.ActivityMainBinding
import android.view.View
import android.content.res.Configuration
import android.support.v7.app.ActionBarDrawerToggle


class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val vm = MainViewModel()
        mBinding.vm = vm

        setActionBar()
        setNavigationDrawer()
    }

    @SuppressLint("RestrictedApi")
    private fun setActionBar() {
        setSupportActionBar(mBinding.mainToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    private fun setNavigationDrawer() {
        mDrawerToggle = object : ActionBarDrawerToggle(
            this, mBinding.drawerLayout, mBinding.mainToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                invalidateOptionsMenu() // creates call to onPrepareOptionsMenu()
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                invalidateOptionsMenu()
                // creates call to onPrepareOptionsMenu()
            }
        }

        mBinding.drawerLayout.setDrawerListener(mDrawerToggle)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mDrawerToggle.onConfigurationChanged(newConfig)
    }
}
