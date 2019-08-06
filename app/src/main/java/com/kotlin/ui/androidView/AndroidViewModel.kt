package com.kotlin.ui.androidView

import android.content.Context
import android.view.View
import com.kotlin.ui.AppNavigator

class AndroidViewModel(private val mContext: Context) {

    fun onBottomMVPClick(view: View) {
        AppNavigator.navigateToMVPActivity(mContext)
    }

    fun onBottomNavigationClick(view: View) {
        AppNavigator.navigateToBottomNavigationActivity(mContext)
    }

    fun onAndroidEmojiLibraryClick(view: View) {
        AppNavigator.navigateToEmojiActivity(mContext)
    }

    fun onRetrofitClick(view: View) {
        AppNavigator.navigateToRetrofitActivity(mContext)
    }

    fun onWithoutUIActivityClick(view: View) {
        AppNavigator.navigateToWithoutUIActivity(mContext)
    }

    fun onAsyncTaskActivityClick(view: View) {
        AppNavigator.navigateToAsyncTaskActivity(mContext)
    }

    fun onCustomViewActivityClick(view: View) {
        AppNavigator.navigateToCustomViewActivity(mContext)
    }

    fun onKeyStoreActivityClick(view: View) {
        AppNavigator.navigateToKeyStoreActivity(mContext)
    }

    fun onBiometricAuthActivityClick(view: View) {
        AppNavigator.navigateToBiometricAuthActivity(mContext)
    }

}