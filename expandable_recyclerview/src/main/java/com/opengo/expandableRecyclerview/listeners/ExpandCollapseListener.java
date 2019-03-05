package com.opengo.expandableRecyclerview.listeners;

public interface ExpandCollapseListener {

    /**
     * Called when a group is expanded
     *
     * @param positionStart
     * @param itemCount
     */
    void onGroupExpanded(int positionStart, int itemCount);

    /**
     * Called when a group is collapsed
     *
     * @param positionStart
     * @param itemCount
     */
    void onGroupCollapsed(int positionStart, int itemCount);
}
