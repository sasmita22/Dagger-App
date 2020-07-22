package com.example.daggerapp;

import android.app.Activity;
import android.app.Application;
import com.example.daggerapp.di.component.ApplicationComponent;
import com.example.daggerapp.di.component.DaggerApplicationComponent;
import com.facebook.stetho.Stetho;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

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
}
