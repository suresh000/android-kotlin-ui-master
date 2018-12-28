package com.kotlin.customview.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import com.kotlin.customview.R;
import com.kotlin.customview.utils.UIUtils;

public class CustomButton extends AppCompatButton {

    public CustomButton(Context context) {
        super(context);
        init(context, null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomButton, 0, 0);

            // set "app_font"
            setFont(typedArray);
        }
    }

    private void setFont(TypedArray typedArray) {
        if (typedArray != null) {
            int font = typedArray.getInteger(R.styleable.CustomButton_app_font, 5);
            setTypeface(UIUtils.getFont(getContext(), font));
        }
    }
}
