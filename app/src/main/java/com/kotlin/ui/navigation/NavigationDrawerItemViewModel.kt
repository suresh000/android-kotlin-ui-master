package com.kotlin.ui.navigation

import android.databinding.ObservableField
import android.graphics.drawable.Drawable

class NavigationDrawerItemViewModel(navImage: Drawable, navText: String) {

    val navImage = ObservableField<Drawable>()
    val navText = ObservableField<String>()

    init {
        this.navImage.set(navImage)
        this.navText.set(navText)
    }

}