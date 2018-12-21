package com.kotlin.ui.home


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.ui.R
import com.kotlin.ui.databinding.FragmentHomeBinding
import com.kotlin.ui.roomDB.AppRoomDatabase

class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
        val vm = HomeViewModel(context!!)
        mBinding.vm = vm

        setAdapter()

        return mBinding.root
    }

    private fun setAdapter() {
        Thread(object : Runnable {

            override fun run() {
                val userList = AppRoomDatabase.getInstance(context!!)!!.userDao().getUserList()
                val userViewModelList = ArrayList<HomeItemViewModel>()
                for (user in userList) {
                    userViewModelList.add(HomeItemViewModel(user))
                }
                val homeAdapter = HomeAdapter(context!!, userViewModelList)
                mBinding.homeRecyclerView.adapter = homeAdapter
                mBinding.homeRecyclerView.layoutManager = LinearLayoutManager(context!!)
            }

        }).start()
    }
}
