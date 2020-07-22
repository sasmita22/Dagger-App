package com.example.daggerapp.di.component;

import android.app.Application;

import com.example.daggerapp.MyApplication;
import com.example.daggerapp.di.module.ContextModule;
import com.example.daggerapp.di.module.MainActivityModule;
import com.example.daggerapp.di.module.RetrofitModule;
import com.example.daggerapp.di.scope.PerApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@PerApplication
@Component(modules = {
        AndroidInjectionModule.class,
        ContextModule.class,
        RetrofitModule.class})
public interface ApplicationComponent {
    MainActivityComponent.Builder getMainActivityComponentBuilder();

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(MyApplication myApplication);
}
