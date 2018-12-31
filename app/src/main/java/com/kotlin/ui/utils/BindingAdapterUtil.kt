package com.kotlin.ui.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.EditText
import android.widget.TextView

object BindingAdapterUtil {

    private const val SET_ON_EDITOR_ACTION_LISTENER = "app:onEditorActionListener"

    @BindingAdapter(SET_ON_EDITOR_ACTION_LISTENER)
    fun setOnEditorActionListener(view: View, onEditorActionListener: TextView.OnEditorActionListener) {
        (view as EditText).setOnEditorActionListener(onEditorActionListener)
    }

}