package com.jaafoura.searchimage.utils;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

/**
 * Thread-safe live data when performing {@link LiveData#setValue(Object)}
 */
public class SafeMutableLiveData<T> extends MutableLiveData<T> {

    @Override
    public void setValue(T value) {
        try {
            super.setValue(value);
        } catch (Exception ex) {
            // if we can't set values due to not in main thread, must call post values instead
            super.postValue(value);
        }
    }
}
