package com.example.daggerapp.di.module;

import com.example.daggerapp.common.network.MealApiService;
import com.example.daggerapp.di.scope.PerApplication;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @PerApplication
    @Provides
    MealApiService providesApiService(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(MealApiService.class);
    }

    @PerApplication
    @Provides
    OkHttpClient providesHttpClient(){
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }
}
