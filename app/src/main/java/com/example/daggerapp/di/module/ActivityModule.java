package com.example.daggerapp.di.module;

import com.example.daggerapp.di.component.MealCategoryActivityComponent;
import com.example.daggerapp.perfeature.mealcategory.view.activity.MealCategoryActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MealCategoryActivityComponent.class)
public abstract class ActivityModule {
    @Binds
    @IntoMap
    @ClassKey(MealCategoryActivity.class)
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MealCategoryActivityComponent.Factory factory);
}
