package com.kotlin.ui

import android.content.Context
import android.content.Intent
import com.kotlin.ui.home.add.AddUserActivity

object AppNavigator {

    fun navigateToAddUserActivity(context: Context) {
        val addUserIntent = Intent(context, AddUserActivity::class.java)
        context.startActivity(addUserIntent)
    }

}