package com.example.daggerapp.di.module;

import android.content.Context;

import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.perfeature.mealcategory.model.Schema.MealCategory;
import com.example.daggerapp.perfeature.mealcategory.view.activity.MealCategoryActivity;
import com.example.daggerapp.di.qualifier.ActivityContext;
import com.example.daggerapp.di.scope.PerActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MealCategoryActivityModule {

    @Binds
    @PerActivity
    @ActivityContext
    abstract Context bindsContext(MealCategoryActivity mealCategoryActivity);

    @Binds
    @PerActivity
    abstract RecyclerViewOnClickListener<MealCategory> bindsListener(MealCategoryActivity mealCategoryActivity);
}
