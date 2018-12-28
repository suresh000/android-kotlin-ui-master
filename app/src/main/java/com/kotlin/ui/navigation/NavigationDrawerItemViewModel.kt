package com.kotlin.ui.navigation

import android.databinding.ObservableField
import android.graphics.drawable.Drawable
import android.view.View

class NavigationDrawerItemViewModel(navImage: Drawable, navText: String, private val type: NavigationViewType,
                                    private val onNavigationItemSelection: NavigationDrawerViewModel.OnNavigationItemSelection) {

    val navImage = ObservableField<Drawable>()
    val navText = ObservableField<String>()

    init {
        this.navImage.set(navImage)
        this.navText.set(navText)
    }

    fun onClick(view: View) {
        onNavigationItemSelection.onSelected(type)
    }

}