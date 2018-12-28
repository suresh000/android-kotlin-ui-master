package com.kotlin.ui.home

import android.content.Context
import android.view.View
import com.kotlin.ui.AppNavigator

class HomeViewModel(private val mContext: Context) {

    fun addUserClick(view: View) {
        AppNavigator.navigateToAddUserActivity(mContext)
    }
}