package com.kotlin.ui.home.add

import android.app.Activity
import android.content.Context
import android.databinding.ObservableField
import android.view.View
import com.kotlin.ui.roomDB.AppRoomDatabase
import com.kotlin.ui.roomDB.entity.User

class AddUserViewModel(private val mActivity: Activity) {

    val name = ObservableField<String>()
    val email = ObservableField<String>()
    val mobile = ObservableField<String>()
    val address = ObservableField<String>()

    fun onSubmitClick(view: View) {
        val userModel = User()
        userModel.setName(name.get()!!.toString())
        userModel.setEmail(email.get()!!.toString())
        userModel.setMobile(mobile.get()!!.toString())
        userModel.setAddress(address.get()!!.toString())

        Thread(object : Runnable {

            override fun run() {
                AppRoomDatabase.getInstance(mActivity)!!.userDao().insert(userModel)
            }

        }).start()

        mActivity.finish()
    }

}