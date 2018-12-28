package com.kotlin.ui.home.add

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.kotlin.ui.R
import com.kotlin.ui.databinding.ActivityAddUserBinding
import com.kotlin.ui.utils.AppUtil

class AddUserActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAddUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityAddUserBinding>(this, R.layout.activity_add_user)
        val vm = AddUserViewModel(this)
        mBinding.vm = vm

        AppUtil.roundedOnlyTopCorner(mBinding.addUserConstraintLayout, 60F)

        setActionBar()
    }

    private fun setActionBar() {
        setSupportActionBar(mBinding.addUserToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.add_user_activity_title)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
