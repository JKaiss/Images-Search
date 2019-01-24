package com.jaafoura.searchimage.ui.adapter;

import com.jaafoura.searchimage.ui.adapter.common.SimpleBaseAdapter;

public abstract class SimpleLayoutAdapter extends SimpleBaseAdapter {
    private final int layoutId;

    public SimpleLayoutAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }
}
