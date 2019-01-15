package com.kotlin.ui.emoji

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.text.emoji.EmojiCompat
import android.support.text.emoji.FontRequestEmojiCompatConfig
import android.support.text.emoji.bundled.BundledEmojiCompatConfig
import android.support.v4.provider.FontRequest
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import com.kotlin.ui.R
import com.kotlin.ui.databinding.ActivityEmojiBinding
import com.kotlin.ui.utils.AppUtil
import java.lang.ref.WeakReference

class EmojiActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"

        /** Change this to `false` when you want to use the downloadable Emoji font.  */
        private const val USE_BUNDLED_EMOJI = true

        // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F4BB] (PERSONAL COMPUTER)
        private const val WOMAN_TECHNOLOGIST = "\uD83D\uDC69\u200D\uD83D\uDCBB"

        // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F3A4] (MICROPHONE)
        private const val WOMAN_SINGER = "\uD83D\uDC69\u200D\uD83C\uDFA4"

        private const val EMOJI = "$WOMAN_TECHNOLOGIST $WOMAN_SINGER"
    }

    private lateinit var mBinding: ActivityEmojiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initEmojiCompat()

        mBinding = DataBindingUtil.setContentView<ActivityEmojiBinding>(this, R.layout.activity_emoji)
        AppUtil.roundedOnlyTopCorner(mBinding.parentCoordinatorLayout, 60F)
        setActionBar()

        // TextView variant provided by EmojiCompat library
        mBinding.emojiTextView.setText(getString(R.string.emoji_text_view, EMOJI))

        // EditText variant provided by EmojiCompat library
        mBinding.emojiEditText.setText(getString(R.string.emoji_edit_text, EMOJI))

        // Button variant provided by EmojiCompat library
        mBinding.emojiButton.setText(getString(R.string.emoji_button, EMOJI))

        // Regular TextView without EmojiCompat support; you have to manually process the text
        EmojiCompat.get().registerInitCallback(InitCallback(mBinding.regularTextView))

        // Custom TextView
        mBinding.emojiCustomTextView.setText(getString(R.string.custom_text_view, EMOJI))
    }

    @SuppressLint("RestrictedApi")
    private fun setActionBar() {
        setSupportActionBar(mBinding.bottomNavigationToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(false)
        supportActionBar!!.title = "Android Emoji"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initEmojiCompat() {
        val config: EmojiCompat.Config
        if (USE_BUNDLED_EMOJI) {
            // Use the bundled font for EmojiCompat
            config = BundledEmojiCompatConfig(applicationContext)
        } else {
            // Use a downloadable font for EmojiCompat
            val fontRequest = FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat",
                R.array.com_google_android_gms_fonts_certs
            )
            config = FontRequestEmojiCompatConfig(applicationContext, fontRequest)
        }

        config.setReplaceAll(true)
            .registerInitCallback(object : EmojiCompat.InitCallback() {
                override fun onInitialized() {
                    Log.i(TAG, "EmojiCompat initialized")
                }

                override fun onFailed(throwable: Throwable?) {
                    Log.e(TAG, "EmojiCompat initialization failed", throwable)
                }
            })

        EmojiCompat.init(config)
    }

    private class InitCallback internal constructor(regularTextView: TextView) : EmojiCompat.InitCallback() {

        private val mRegularTextViewRef: WeakReference<TextView>

        init {
            mRegularTextViewRef = WeakReference(regularTextView)
        }

        override fun onInitialized() {
            val regularTextView = mRegularTextViewRef.get()
            if (regularTextView != null) {
                val compat = EmojiCompat.get()
                val context = regularTextView.getContext()
                regularTextView.setText(
                    compat.process(context.getString(R.string.regular_text_view, EMOJI))
                )
            }
        }

    }
}
