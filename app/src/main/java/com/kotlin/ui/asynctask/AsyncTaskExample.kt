package com.kotlin.ui.asynctask

import android.os.AsyncTask
import android.util.Log

class AsyncTaskExample(val listener: TaskListener) : AsyncTask<String, Integer, String>() {

    override fun onPreExecute() {
        listener.onTaskStarted()
    }

    override fun doInBackground(vararg params: String): String {
        for (i in 1..10) {
            Log.d("GREC", "AsyncTask is working: $i")
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        return "All Done!"
    }

    override fun onPostExecute(result: String) {
        listener.onTaskFinished(result)
    }
}