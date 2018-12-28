package com.kotlin.customview.widgets

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.kotlin.customview.R
import com.kotlin.customview.utils.UIUtils

class CustomTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView, 0, 0
            )

            // set "app_font"
            setFont(typedArray)
        }
    }

    private fun setFont(typedArray: TypedArray?) {
        if (typedArray != null) {
            val font = typedArray.getInteger(R.styleable.CustomTextView_app_font, 5)
            typeface = UIUtils.getFont(context, font)
        }
    }
}
