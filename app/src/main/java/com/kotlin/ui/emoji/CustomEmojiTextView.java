package com.kotlin.ui.emoji;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.text.emoji.widget.EmojiTextViewHelper;
import android.support.v7.widget.AppCompatTextView;
import android.text.InputFilter;
import android.util.AttributeSet;


/**
 * A sample implementation of custom TextView.
 *
 * <p>You can use {@link EmojiTextViewHelper} to make your custom TextView compatible with
 * EmojiCompat.</p>
 */
public class CustomEmojiTextView extends AppCompatTextView {

    private EmojiTextViewHelper mEmojiTextViewHelper;

    public CustomEmojiTextView(Context context) {
        this(context, null);
    }

    public CustomEmojiTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomEmojiTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getEmojiTextViewHelper().updateTransformationMethod();
    }

    @Override
    public void setFilters(InputFilter[] filters) {
        super.setFilters(getEmojiTextViewHelper().getFilters(filters));
    }

    @Override
    public void setAllCaps(boolean allCaps) {
        super.setAllCaps(allCaps);
        getEmojiTextViewHelper().setAllCaps(allCaps);
    }

    /**
     * Returns the {@link EmojiTextViewHelper} for this TextView.
     *
     * <p>This method can be called from super constructors through {@link
     * #setFilters(InputFilter[])} or {@link #setAllCaps(boolean)}.</p>
     */
    private EmojiTextViewHelper getEmojiTextViewHelper() {
        if (mEmojiTextViewHelper == null) {
            mEmojiTextViewHelper = new EmojiTextViewHelper(this);
        }
        return mEmojiTextViewHelper;
    }

}
