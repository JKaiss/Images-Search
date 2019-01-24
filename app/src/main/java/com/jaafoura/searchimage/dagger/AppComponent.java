package com.jaafoura.searchimage.dagger;

import android.content.Context;
import android.support.annotation.NonNull;

import com.jaafoura.searchimage.App;
import com.jaafoura.searchimage.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class})
public abstract class AppComponent {

    public static AppComponent from(@NonNull Context context) {
        return ((App) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(MainActivity mainActivity);

}
