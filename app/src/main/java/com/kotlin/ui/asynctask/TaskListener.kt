package com.kotlin.ui.asynctask

interface TaskListener {

    fun onTaskStarted()

    fun onTaskFinished(result: String)
}