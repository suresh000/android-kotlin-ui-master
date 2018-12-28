package com.kotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getCurrentFragment(): Fragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun addFragment(fragment: Fragment, tag: String, container: Int) {
        Thread(object : Runnable {

            override fun run() {
                var currentFragmentName = ""
                val f = getCurrentFragment()
                if (f != null) {
                    currentFragmentName = f::class.java.name
                }
                if (fragment::class.java.name.equals(currentFragmentName)) {
                    return
                }

                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()

                transaction.setCustomAnimations(R.anim.slide_in_down, 0, 0, R.anim.slide_out_down)

                transaction.add(container, fragment)
                transaction.commit()
            }

        }).start()
    }

    protected fun replaceFragment(fragment: Fragment, tag: String, container: Int) {
        Thread(object : Runnable {

            override fun run() {
                var currentFragmentName = ""
                val f = getCurrentFragment()
                if (f != null) {
                    currentFragmentName = f::class.java.name
                }
                if (fragment::class.java.name.equals(currentFragmentName)) {
                    return
                }

                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()

                transaction.setCustomAnimations(R.anim.slide_in_down, 0, 0, R.anim.slide_out_down)

                transaction.replace(container, fragment)
                transaction.commit()
            }

        }).start()

    }

}