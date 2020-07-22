package com.example.daggerapp.di.module;

import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.di.scope.PerActivity;
import com.example.daggerapp.mealcategory.view.MainActivity;
import com.example.daggerapp.mealcategory.view.adapter.CategoryMealAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {
    @Provides
    @PerActivity
    CategoryMealAdapter providesCategoryAdapter(RecyclerViewOnClickListener listener){
        return new CategoryMealAdapter(listener);
    }

    @Provides
    @PerActivity
    RecyclerViewOnClickListener providesListener(MainActivity mainActivity){
        return mainActivity;
    }
}
