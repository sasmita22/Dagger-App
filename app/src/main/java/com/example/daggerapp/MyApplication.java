package com.example.daggerapp;

import android.app.Activity;
import android.app.Application;
import com.example.daggerapp.di.component.ApplicationComponent;
import com.example.daggerapp.di.component.DaggerApplicationComponent;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class MyApplication extends Application implements HasAndroidInjector {
    ApplicationComponent applicationComponent;

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build();
        applicationComponent.inject(this);
    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
