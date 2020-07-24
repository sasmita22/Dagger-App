package com.example.daggerapp.di.component;

import com.example.daggerapp.di.module.MealCategoryActivityModule;
import com.example.daggerapp.di.scope.PerActivity;
import com.example.daggerapp.perfeature.mealbycategory.view.activity.MealByCategoryActivity;
import com.example.daggerapp.perfeature.mealcategory.view.activity.MealCategoryActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(modules = {MealCategoryActivityModule.class})
public interface MealCategoryActivityComponent extends AndroidInjector<MealCategoryActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MealCategoryActivity>{
        MealCategoryActivityComponent create(@BindsInstance MealCategoryActivity mealCategoryActivity);
    }
}
