package com.kotlin.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kotlin.ui.BR;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class DataBindingRecyclerViewAdapter extends RecyclerView.Adapter<DataBindingRecyclerViewHolder> {

    protected List<ViewModel> mViewModels = new ArrayList<>();

    public DataBindingRecyclerViewAdapter(List<ViewModel> viewModels) {
        this.mViewModels = viewModels;
        onViewModelListChanged();
    }


    @NotNull
    @Override
    public DataBindingRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);

        return new DataBindingRecyclerViewHolder<>(DataBindingUtil.bind(v));
    }

    @Override
    public void onBindViewHolder(@NotNull DataBindingRecyclerViewHolder holder, int position) {
        if (mViewModels != null && mViewModels.size() > position) {
            ViewModel viewModel = mViewModels.get(position);
            if (viewModel != null) {
                holder.getBinding().setVariable(BR.vm, viewModel);
                holder.getBinding().executePendingBindings();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return getViewModelLayoutMap().get(mViewModels.get(position).getClass());
    }


    @Override
    public int getItemCount() {
        return mViewModels == null ? 0 : mViewModels.size();
    }

    public abstract Map<Class, Integer> getViewModelLayoutMap();


    public void onViewModelListChanged() {
        notifyDataSetChanged();
    }

    public void close() {
    }

    public void refreshList(List<ViewModel> viewModels) {
        mViewModels.clear();
        mViewModels.addAll(viewModels);
        notifyDataSetChanged();
    }
}
