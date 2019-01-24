package com.jaafoura.searchimage;

import android.app.Application;

import com.jaafoura.searchimage.dagger.AppComponent;
import com.jaafoura.searchimage.dagger.AppModule;
import com.jaafoura.searchimage.dagger.DaggerAppComponent;


public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
