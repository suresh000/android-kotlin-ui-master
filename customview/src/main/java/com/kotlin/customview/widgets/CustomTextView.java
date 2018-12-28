package com.kotlin.customview.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.kotlin.customview.R;
import com.kotlin.customview.utils.UIUtils;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
        init(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomTextView, 0, 0);

            // set "app_font"
            setFont(typedArray);
        }
    }

    private void setFont(TypedArray typedArray) {
        if (typedArray != null) {
            int font = typedArray.getInteger(R.styleable.CustomTextView_app_font, 5);
            setTypeface(UIUtils.getFont(getContext(), font));
        }
    }
}
