package com.kotlin.ui.home.add

import android.arch.persistence.room.Room
import android.content.Context
import android.databinding.ObservableField
import android.view.View
import com.kotlin.ui.roomDB.MyRoomDatabase
import com.kotlin.ui.roomDB.entity.User

class AddUserViewModel(private val mContext: Context) {

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

        MyRoomDatabase.getInstance(mContext)!!.userDao().insert(userModel)
    }

}