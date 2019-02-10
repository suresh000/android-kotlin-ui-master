package com.kotlin.ui.customView

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class CustomViewActivity : AppCompatActivity() {

    private lateinit var mView: OurSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mView = OurSurfaceView(this)

        setContentView(mView)
    }

    override fun onResume() {
        super.onResume()
        mView.resume()
    }

    override fun onPause() {
        super.onPause()
        mView.pause()
    }
}
