package com.example.daggerapp.di.module;

import android.app.Application;
import android.content.Context;

import com.example.daggerapp.di.qualifier.ApplicationContext;
import com.example.daggerapp.di.scope.PerApplication;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {
    @Binds
    @PerApplication
    @ApplicationContext
    abstract Context bindsContext(Application application);
}
