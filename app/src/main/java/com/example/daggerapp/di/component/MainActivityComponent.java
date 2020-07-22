package com.example.daggerapp.di.component;

import com.example.daggerapp.di.module.AdapterModule;
import com.example.daggerapp.di.module.MainActivityModule;
import com.example.daggerapp.di.scope.PerActivity;
import com.example.daggerapp.mealcategory.view.MainActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {AdapterModule.class, MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder mainActivity(MainActivity mainActivity);

        MainActivityComponent build();
    }
}
