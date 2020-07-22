package com.example.daggerapp.di.module;

import android.content.Context;

import com.example.daggerapp.mealcategory.view.MainActivity;
import com.example.daggerapp.di.qualifier.ActivityContext;
import com.example.daggerapp.di.scope.PerActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    @Binds
    @PerActivity
    @ActivityContext
    abstract Context providesContext(MainActivity mainActivity);
}
