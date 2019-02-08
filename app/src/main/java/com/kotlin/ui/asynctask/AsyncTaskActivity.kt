package com.kotlin.ui.asynctask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.ui.R
import android.app.ProgressDialog



class AsyncTaskActivity : AppCompatActivity(), TaskListener {

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        AsyncTaskExample(this).execute()
    }

    override fun onTaskStarted() {
        progressDialog = ProgressDialog.show(this, "Loading", "Please wait a moment!");
    }

    override fun onTaskFinished(result: String) {
        progressDialog.dismiss()
    }
}
