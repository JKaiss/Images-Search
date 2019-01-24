package com.jaafoura.searchimage.ui.form;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.jaafoura.searchimage.BR;

/**
 * Contain data of search edit text, notify when it change
 */
public class SearchFrom extends BaseObservable {

    private String searchText;

    @Bindable
    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String customName) {
        this.searchText = customName;
        notifyPropertyChanged(BR.searchText);
    }

}
