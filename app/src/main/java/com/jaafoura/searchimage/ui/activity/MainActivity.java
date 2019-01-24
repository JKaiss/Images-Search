package com.jaafoura.searchimage.ui.activity;

import android.databinding.Observable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.SnapHelper;
import android.widget.Toast;

import com.jaafoura.searchimage.BR;
import com.jaafoura.searchimage.R;
import com.jaafoura.searchimage.dagger.AppComponent;
import com.jaafoura.searchimage.data.model.ResponseEntity;
import com.jaafoura.searchimage.databinding.ActivityMainBinding;
import com.jaafoura.searchimage.ui.adapter.SimpleLayoutAdapter;
import com.jaafoura.searchimage.ui.form.SearchFrom;
import com.jaafoura.searchimage.viewmodel.MainViewModel;

import javax.inject.Inject;

/**
 * Main view containing search and list of results
 */
public class MainActivity extends AbstractActivity<ActivityMainBinding> {

    //region Properties
    /**
     * Call handling form changes
     */
    private Observable.OnPropertyChangedCallback propertyCallback = null;

    @Inject
    MainViewModel viewModel;

    private SimpleLayoutAdapter adapter;
    private SearchFrom form;

    //endregion

    //region ui
    @Override
    protected void initializeUI() {
        binding.setVariable(BR.from, form = new SearchFrom());
        // Inject activity
        AppComponent.from(this).inject(this);
        // set horizontal recyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerViewImage.setLayoutManager(layoutManager);
        // make horizontal scroll like viewpager
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.recyclerViewImage);

        viewModel.getResultDisposableSingleObserver().observe(this, this::bindImageList);


        form.addOnPropertyChangedCallback(propertyCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (BR.searchText == propertyId) {
                    viewModel.getImagesByName(form.getSearchText());
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    //endregion


    //region Update list

    private void bindImageList(ResponseEntity responseEntity) {
        if (responseEntity.getResults().isEmpty()) {
            Toast.makeText(this, "vide", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "size : " + responseEntity.getResults().size(), Toast.LENGTH_LONG).show();
            adapter = new SimpleLayoutAdapter(R.layout.holder_image) {
                @Override
                protected Object getObjForPosition(int position) {
                    return responseEntity.getResults().get(position);
                }

                @Override
                public int getItemCount() {
                    return responseEntity.getResults().size();
                }
            };
            binding.recyclerViewImage.setAdapter(adapter);
        }
    }

    //endregion


    //region Life Cycle

    @Override
    protected void onDestroy() {
        super.onDestroy();
        form.removeOnPropertyChangedCallback(propertyCallback);
    }

    //endregion

}
