package com.kotlin.ui

import android.content.Context
import android.content.Intent
import com.kotlin.ui.bottomNavigation.BottomNavigationActivity
import com.kotlin.ui.emoji.EmojiActivity
import com.kotlin.ui.google.GoogleActivity
import com.kotlin.ui.home.add.AddUserActivity
import com.kotlin.ui.retrofitExample.RetrofitActivity

object AppNavigator {

    fun navigateToAddUserActivity(context: Context) {
        val addUserIntent = Intent(context, AddUserActivity::class.java)
        context.startActivity(addUserIntent)
    }

    fun navigateToBottomNavigationActivity(context: Context) {
        val intent = Intent(context, BottomNavigationActivity::class.java)
        context.startActivity(intent)
    }

    fun navigateToGoogleActivity(context: Context) {
        val googleIntent = Intent(context, GoogleActivity::class.java)
        context.startActivity(googleIntent)
    }

    fun navigateToEmojiActivity(context: Context) {
        val intent = Intent(context, EmojiActivity::class.java)
        context.startActivity(intent)
    }

    fun navigateToRetrofitActivity(context: Context) {
        val intent = Intent(context, RetrofitActivity::class.java)
        context.startActivity(intent)
    }

}