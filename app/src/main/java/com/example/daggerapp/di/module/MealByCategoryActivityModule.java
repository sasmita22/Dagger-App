package com.example.daggerapp.di.module;

import android.content.Context;

import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.di.qualifier.ActivityContext;
import com.example.daggerapp.di.scope.PerActivity;
import com.example.daggerapp.perfeature.mealbycategory.model.schema.Meal;
import com.example.daggerapp.perfeature.mealbycategory.view.activity.MealByCategoryActivity;
import com.example.daggerapp.perfeature.mealcategory.model.Schema.MealCategory;
import com.example.daggerapp.perfeature.mealcategory.view.activity.MealCategoryActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MealByCategoryActivityModule {
    @Binds
    @PerActivity
    @ActivityContext
    abstract Context bindsContext(MealByCategoryActivity mealByCategoryActivity);

    @Binds
    @PerActivity
    abstract RecyclerViewOnClickListener<Meal> bindsListener(MealByCategoryActivity mealCategoryActivity);
}
