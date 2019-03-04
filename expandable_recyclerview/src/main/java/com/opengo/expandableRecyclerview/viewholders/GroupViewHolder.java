package com.opengo.expandableRecyclerview.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.opengo.expandableRecyclerview.listeners.OnGroupClickListener;

public abstract class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnGroupClickListener listener;

    public GroupViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onGroupClick(getAdapterPosition());
        }
    }

    public void setOnGroupClickListener(OnGroupClickListener listener) {
        this.listener = listener;
    }

    public void expand() {}

    public void collapse() {}
}
