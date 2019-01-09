package com.kotlin.ui.bottomNavigation

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.kotlin.ui.BaseActivity
import com.kotlin.ui.R
import com.kotlin.ui.bottomNavigation.cart.CartFragment
import com.kotlin.ui.bottomNavigation.gifts.GiftsFragment
import com.kotlin.ui.bottomNavigation.profile.ProfileFragment
import com.kotlin.ui.bottomNavigation.store.StoreFragment
import com.kotlin.ui.databinding.ActivityBottomNavigationBinding
import com.kotlin.ui.utils.AppUtil

class BottomNavigationActivity : BaseActivity() {

    private val FRAGMENT_CONTAINER_ID = R.id.bottomNavigationContainer

    override fun getCurrentFragment(): Fragment? {
        val manager = getSupportFragmentManager()
        return manager.findFragmentById(FRAGMENT_CONTAINER_ID)
    }

    private lateinit var mBinding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_navigation)

        AppUtil.roundedOnlyTopCorner(mBinding.parentCoordinatorLayout, 60F)

        setActionBar()

        mBinding.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(StoreFragment(), resources.getString(R.string.title_shop), FRAGMENT_CONTAINER_ID)
    }

    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_shop -> {
                        setToolbarTitle(resources.getString(R.string.title_shop))
                        replaceFragment(StoreFragment(), resources.getString(R.string.title_shop), FRAGMENT_CONTAINER_ID)
                        return true
                    }
                    R.id.navigation_gifts -> {
                        setToolbarTitle(resources.getString(R.string.title_gifts))
                        replaceFragment(GiftsFragment(), resources.getString(R.string.title_gifts), FRAGMENT_CONTAINER_ID)
                        return true
                    }
                    R.id.navigation_cart -> {
                        setToolbarTitle(resources.getString(R.string.title_cart))
                        replaceFragment(CartFragment(), resources.getString(R.string.title_cart), FRAGMENT_CONTAINER_ID)
                        return true
                    }
                    R.id.navigation_profile -> {
                        setToolbarTitle(resources.getString(R.string.title_profile))
                        replaceFragment(ProfileFragment(), resources.getString(R.string.title_profile), FRAGMENT_CONTAINER_ID)
                        return true
                    }
                }
                return false
            }

        }

    @SuppressLint("RestrictedApi")
    private fun setActionBar() {
        setSupportActionBar(mBinding.bottomNavigationToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(false)
        setToolbarTitle(resources.getString(R.string.title_shop))
    }

    private fun setToolbarTitle(title: String) {
        supportActionBar!!.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
