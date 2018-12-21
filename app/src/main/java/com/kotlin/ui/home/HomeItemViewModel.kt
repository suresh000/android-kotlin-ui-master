package com.kotlin.ui.home

import android.databinding.ObservableField
import com.kotlin.ui.roomDB.entity.User

class HomeItemViewModel(user: User) {

    val userModel = ObservableField<User>(user)

}