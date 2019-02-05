package com.kotlin.ui.retrofitExample

import com.kotlin.ui.R
import com.kotlin.ui.adapter.DataBindingRecyclerViewAdapter
import com.kotlin.ui.adapter.ViewModel
import java.util.HashMap

class RetrofitAdapter(viewModels: List<ViewModel>) : DataBindingRecyclerViewAdapter(viewModels) {

    private var mViewModelMap: MutableMap<Class<*>, Int> = HashMap()

    init {
        mViewModelMap[RetrofitItemViewModel::class.java] = R.layout.retrofit_movie_item
    }

    override fun getViewModelLayoutMap(): Map<Class<*>, Int> {
        return mViewModelMap
    }
}
