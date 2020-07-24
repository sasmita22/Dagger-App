package com.example.daggerapp.di.component;

import com.example.daggerapp.di.module.MealByCategoryActivityModule;
import com.example.daggerapp.di.scope.PerActivity;
import com.example.daggerapp.perfeature.mealbycategory.view.activity.MealByCategoryActivity;
import com.example.daggerapp.perfeature.mealcategory.view.activity.MealCategoryActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {MealByCategoryActivityModule.class, })
public interface MealByCategoryComponent {
    void inject(MealByCategoryActivity activity);

    @Subcomponent.Factory
    interface Factory{
        MealByCategoryComponent create(@BindsInstance MealByCategoryActivity mealByCategoryActivity);
    }
}
