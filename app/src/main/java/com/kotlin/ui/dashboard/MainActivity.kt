package com.kotlin.ui.dashboard

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.kotlin.ui.BaseActivity
import com.kotlin.ui.R
import com.kotlin.ui.databinding.ActivityMainBinding
import android.view.View
import android.content.res.Configuration
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.widget.Toast
import com.kotlin.ui.home.HomeFragment
import com.kotlin.ui.navigation.NavigationDrawerFragment
import com.kotlin.ui.navigation.NavigationViewType
import com.kotlin.ui.utils.AppUtil
import android.support.v4.view.GravityCompat
import com.kotlin.ui.AppNavigator
import com.kotlin.ui.aboutUs.AboutUsFragment
import com.kotlin.ui.utils.AppPermissionUtil


class MainActivity : BaseActivity(), NavigationDrawerFragment.NavigationDrawerCallback {

    private val FRAGMENT_RESOURCE_ID = R.id.mainFrameLayoutContainer
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val vm = MainViewModel()
        mBinding.vm = vm

        AppUtil.roundedOnlyTopCorner(mBinding.parentConstraintLayout, 60F)

        setActionBar("User List")
        setNavigationDrawer()

        addFragment(HomeFragment(), "navHome", R.id.mainFrameLayoutContainer)
    }

    @SuppressLint("RestrictedApi")
    private fun setActionBar(title: String) {
        setSupportActionBar(mBinding.mainToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(false)
        supportActionBar!!.title = title
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

    override fun getCurrentFragment(): Fragment? {
        val manager = getSupportFragmentManager()
        return manager.findFragmentById(FRAGMENT_RESOURCE_ID)
    }

    /**
     * Close the Navigation drawer
     */
    fun closeDrawer() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onNavigationDrawerItemSelected(type: NavigationViewType) {
        closeDrawer()
        when (type) {
            NavigationViewType.HOME -> {
                setActionBar("User List")
                replaceFragment(HomeFragment(), "navHome", R.id.mainFrameLayoutContainer)
            }
            NavigationViewType.GOOGLE -> {
                if (AppUtil.isGoogleServicesOK(this)) {
                    if (AppPermissionUtil.isLocationPermissionAllow(this)) {
                        AppNavigator.navigateToGoogleActivity(this)
                    }
                }
            }
            NavigationViewType.PROFILE -> {

            }
            NavigationViewType.ABOUT_US -> {
                setActionBar("About US")
                replaceFragment(AboutUsFragment(), "navAboutUs", R.id.mainFrameLayoutContainer)
            }
            NavigationViewType.LOGOUT -> {
                AppUtil.showToast(this, "Logout click...", true)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            AppPermissionUtil.LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.size > 0) {
                    var allowPermission = true
                    for (i in grantResults) {
                        if (i != PackageManager.PERMISSION_GRANTED) {
                            allowPermission = false
                        }
                    }
                    if (allowPermission) {
                        AppNavigator.navigateToGoogleActivity(this)
                    }
                    else {
                        AppUtil.showSnackbar(mBinding.mainCoordinatorLayout, "Google Api must need location permission", true)
                    }
                }
            }
        }
    }
}
