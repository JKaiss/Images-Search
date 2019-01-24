package com.jaafoura.searchimage.ui.adapter.common;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.jaafoura.searchimage.BR;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public SimpleViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.result, obj);
        binding.executePendingBindings();
    }
}
