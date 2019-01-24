package com.jaafoura.searchimage.viewmodel.common;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;

public abstract class AbstratViewModel extends ViewModel {

    @NonNull
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
        mCompositeDisposable = new CompositeDisposable();
    }
}
