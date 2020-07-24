package com.example.daggerapp.perfeature.mealbycategory.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.daggerapp.MyApplication;
import com.example.daggerapp.common.constant.IntentKeyword;
import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.common.network.MealApiService;
import com.example.daggerapp.databinding.ActivityMealByCategoryBinding;
import com.example.daggerapp.di.qualifier.ActivityContext;
import com.example.daggerapp.di.qualifier.ApplicationContext;
import com.example.daggerapp.perfeature.mealbycategory.model.schema.Meal;
import com.example.daggerapp.perfeature.mealbycategory.view.adapter.MealAdapter;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MealByCategoryActivity extends AppCompatActivity
implements RecyclerViewOnClickListener<Meal> {
    ActivityMealByCategoryBinding binding;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    MealAdapter adapter;

    @Inject
    MealApiService mealApiService;

    @ActivityContext
    @Inject
    Context activityContext;

    @ApplicationContext
    @Inject
    Context appContext;

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealByCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();

        MyApplication.get(this)
                .getApplicationComponent()
                .getMealByCategoryComponentFactory()
                .create(this)
                .inject(this);

        binding.recyclerview.setAdapter(adapter);

        loadMeal();
    }

    private void getIntentExtra() {
        category = getIntent().getStringExtra(IntentKeyword.CATEGORY_NAME);
    }

    private void loadMeal() {
        compositeDisposable.add(
                mealApiService.getMeals(category)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(result -> adapter.updateData(result.getMeals()))
        );
    }

    @Override
    public void onClickListItem(Meal item) {

    }
}