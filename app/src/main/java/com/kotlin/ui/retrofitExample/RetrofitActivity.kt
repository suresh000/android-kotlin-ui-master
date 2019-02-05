package com.kotlin.ui.retrofitExample

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.kotlin.ui.R
import com.kotlin.ui.apiClient.ApiClient
import com.kotlin.ui.apiClient.ApiInterface
import com.kotlin.ui.databinding.ActivityRetrofitBinding
import com.kotlin.ui.utils.AppUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRetrofitBinding
    private lateinit var mViewModel: RetrofitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)
        mViewModel = RetrofitViewModel(this)
        mBinding.vm = mViewModel

        AppUtil.roundedOnlyTopCorner(mBinding.parentConstraintLayout, 60F)

        setActionBar()
    }

    private fun setActionBar() {
        setSupportActionBar(mBinding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Retrofit"
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
