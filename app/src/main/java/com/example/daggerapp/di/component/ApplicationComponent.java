package com.example.daggerapp.di.component;

import android.app.Application;

import com.example.daggerapp.MyApplication;
import com.example.daggerapp.di.module.ActivityModule;
import com.example.daggerapp.di.module.AppModule;
import com.example.daggerapp.di.module.RetrofitModule;
import com.example.daggerapp.di.scope.PerApplication;

import dagger.BindsInstance;
import dagger.Component;

@PerApplication
@Component(modules = {
        AppModule.class,
        ActivityModule.class,
        RetrofitModule.class})
public interface ApplicationComponent {
    MealCategoryActivityComponent.Factory getMealCategoryActivityComponentFactory();
    MealByCategoryComponent.Factory getMealByCategoryComponentFactory();

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(MyApplication myApplication);
}
