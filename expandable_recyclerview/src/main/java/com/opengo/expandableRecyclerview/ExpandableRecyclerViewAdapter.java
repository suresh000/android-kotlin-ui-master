package com.opengo.expandableRecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.opengo.expandableRecyclerview.listeners.ExpandCollapseListener;
import com.opengo.expandableRecyclerview.listeners.OnGroupClickListener;
import com.opengo.expandableRecyclerview.models.ExpandableListPosition;
import com.opengo.expandableRecyclerview.viewholders.ChildViewHolder;
import com.opengo.expandableRecyclerview.viewholders.GroupViewHolder;

public abstract class ExpandableRecyclerViewAdapter<GVH extends GroupViewHolder,
        CVH extends ChildViewHolder> extends RecyclerView.Adapter
        implements ExpandCollapseListener, OnGroupClickListener {

    public abstract GVH onCreateGroupViewHolder(ViewGroup parent, int viewType);
    public abstract CVH onCreateChildViewHolder(ViewGroup parent, int viewType);

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case ExpandableListPosition.GROUP:
                GVH gvh = onCreateGroupViewHolder(viewGroup, viewType);
                gvh.setOnGroupClickListener(this);
                return gvh;
            case ExpandableListPosition.CHILD:
                CVH cvh = onCreateChildViewHolder(viewGroup, viewType);
                return cvh;
            default:
                throw new IllegalArgumentException("viewType is not valid");

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onGroupExpanded(int positionStart, int itemCount) {

    }

    @Override
    public void onGroupCollapsed(int positionStart, int itemCount) {

    }

    @Override
    public boolean onGroupClick(int groupPosition) {
        return false;
    }
}
