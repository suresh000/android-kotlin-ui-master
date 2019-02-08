package com.kotlin.ui.activityWithoutUi

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class WithoutUIActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // work here
        Toast.makeText(this, "I'm alive", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        // finish activity after complete your work
        finish()
    }
}
