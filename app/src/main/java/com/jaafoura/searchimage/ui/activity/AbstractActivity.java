package com.jaafoura.searchimage.ui.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Abstract of activity that init dataBiding and can contain other variable used in each activity
 * @param <D> generic type of data binding
 */
public abstract class AbstractActivity<D extends ViewDataBinding> extends AppCompatActivity {

    /**
     * DataBinding instance of the view
     */
    D binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initializeUI();
    }

    /**
     * init ui
     */
    protected abstract void initializeUI();

    /**
     * @return id of the layout
     */
    protected abstract int getLayoutId();
}
