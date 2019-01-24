package com.jaafoura.searchimage.dagger;

import android.app.Application;

import com.jaafoura.searchimage.data.network.SearchImageApi;
import com.jaafoura.searchimage.utils.Constants;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private static final long TIME_OUT = 5000;

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }



    @Provides
    @Singleton
    public SearchImageApi providesSearchImageApi() {
        return new Retrofit.Builder().baseUrl(Constants.baseURL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SearchImageApi.class);
    }

    private OkHttpClient createClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder b = new OkHttpClient.Builder();
        b.connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        b.readTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        b.writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        b.addInterceptor(logging);
        OkHttpClient okHttpClient = b.build();

        return okHttpClient;
    }

}
