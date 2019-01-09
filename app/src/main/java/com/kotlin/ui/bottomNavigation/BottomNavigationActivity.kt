package com.kotlin.ui.bottomNavigation

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
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

    companion object {
        const val SHOP = "Shop"
        const val MY_GIFTS = "My Gifts"
        const val CART = "Cart"
        const val PROFILE = "Profile"
    }

    private lateinit var mBinding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_navigation)

        AppUtil.roundedOnlyTopCorner(mBinding.parentCoordinatorLayout, 60F)

        setActionBar()

        mBinding.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(StoreFragment(), SHOP, FRAGMENT_CONTAINER_ID)
    }

    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_shop -> {
                        setToolbarTitle(SHOP)
                        replaceFragment(StoreFragment(), SHOP, FRAGMENT_CONTAINER_ID)
                        return true
                    }
                    R.id.navigation_gifts -> {
                        setToolbarTitle(MY_GIFTS)
                        replaceFragment(GiftsFragment(), MY_GIFTS, FRAGMENT_CONTAINER_ID)
                        return true
                    }
                    R.id.navigation_cart -> {
                        setToolbarTitle(CART)
                        replaceFragment(CartFragment(), CART, FRAGMENT_CONTAINER_ID)
                        return true
                    }
                    R.id.navigation_profile -> {
                        setToolbarTitle(PROFILE)
                        replaceFragment(ProfileFragment(), PROFILE, FRAGMENT_CONTAINER_ID)
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
        setToolbarTitle(SHOP)
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
