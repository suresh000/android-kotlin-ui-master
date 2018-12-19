package com.kotlin.ui.navigation

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.ui.R
import com.kotlin.ui.databinding.NavigationDrawerItemBinding

class NavigationDrawerAdapter(context: Context, private val mNavList: List<NavigationDrawerItemViewModel>) :
    RecyclerView.Adapter<NavigationDrawerAdapter.NavigationDrawerViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(container: ViewGroup, position: Int): NavigationDrawerViewHolder {
        val view = DataBindingUtil.inflate<NavigationDrawerItemBinding>(
            mInflater,
            R.layout.navigation_drawer_item,
            container,
            false
        )
        return NavigationDrawerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mNavList.size
    }

    override fun onBindViewHolder(viewHolder: NavigationDrawerViewHolder, position: Int) {
        viewHolder.showData(mNavList.get(position))
    }

    inner class NavigationDrawerViewHolder(val rowViewBinding: NavigationDrawerItemBinding) :
        RecyclerView.ViewHolder(rowViewBinding.root) {

        fun showData(item: NavigationDrawerItemViewModel) {
            rowViewBinding.vm = item
        }
    }
}