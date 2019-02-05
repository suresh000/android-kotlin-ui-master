package com.kotlin.ui.androidView

import android.content.Context
import android.view.View
import com.kotlin.ui.AppNavigator

class AndroidViewModel(val mContext: Context) {

    fun onBottomNavigationClick(view: View) {
        AppNavigator.navigateToBottomNavigationActivity(mContext)
    }

    fun onAndroidEmojiLibraryClick(view: View) {
        AppNavigator.navigateToEmojiActivity(mContext)
    }

    fun onRetrofitClick(view: View) {
        AppNavigator.navigateToRetrofitActivity(mContext)
    }

}