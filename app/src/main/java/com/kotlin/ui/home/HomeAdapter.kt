package com.kotlin.ui.home

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.ui.R
import com.kotlin.ui.databinding.HomeItemLayoutBinding



class HomeAdapter(private val mContext: Context, private var mUserList: List<HomeItemViewModel>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val mInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(container: ViewGroup, position: Int): HomeViewHolder {
        val rowBinding = DataBindingUtil.inflate<HomeItemLayoutBinding>(mInflater, R.layout.home_item_layout, container, false)
        return HomeViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
        return mUserList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.showData(mUserList.get(position))
    }

    fun addItems(userList: List<HomeItemViewModel>) {
        mUserList = userList
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(val rowBinding: HomeItemLayoutBinding) : RecyclerView.ViewHolder(rowBinding.root) {

        fun showData(itemViewModel: HomeItemViewModel) {
            rowBinding.vm = itemViewModel
        }
    }
}