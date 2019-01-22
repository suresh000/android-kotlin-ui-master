package com.kotlin.ui.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewBindingUtils {

    private final static String ADAPTER = "setRecyclerViewAdapter";

    @BindingAdapter({ADAPTER})
    public static void bindRecyclerViewAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
    }

}
