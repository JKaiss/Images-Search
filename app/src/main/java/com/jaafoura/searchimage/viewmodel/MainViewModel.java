package com.jaafoura.searchimage.viewmodel;

import com.jaafoura.searchimage.data.model.ResponseEntity;
import com.jaafoura.searchimage.data.network.SearchImageApi;
import com.jaafoura.searchimage.utils.SafeMutableLiveData;
import com.jaafoura.searchimage.viewmodel.common.AbstratViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Getter;

import static com.jaafoura.searchimage.utils.Constants.ACCESS_KEY;

/**
 * ViewModel for main activity, it retrieve data from api
 */
public class MainViewModel extends AbstratViewModel {

    private final SearchImageApi searchImageApi;

    @Getter
    private SafeMutableLiveData<ResponseEntity> resultDisposableSingleObserver = new SafeMutableLiveData<>();

    @Inject
    public MainViewModel(SearchImageApi searchImageApi) {
        this.searchImageApi = searchImageApi;
    }

    public void getImagesByName(String searchText) {
        mCompositeDisposable.add(searchImageApi.getImages(ACCESS_KEY, searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultDisposableSingleObserver::setValue));
    }

}
