package com.example.daggerapp.perfeature.mealcategory.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.daggerapp.MyApplication;
import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.common.network.MealApiService;
import com.example.daggerapp.databinding.ActivityMainBinding;
import com.example.daggerapp.di.qualifier.ActivityContext;
import com.example.daggerapp.di.qualifier.ApplicationContext;
import com.example.daggerapp.perfeature.mealbycategory.view.activity.MealByCategoryActivity;
import com.example.daggerapp.perfeature.mealcategory.model.Schema.MealCategory;
import com.example.daggerapp.perfeature.mealcategory.view.adapter.CategoryMealAdapter;
import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static com.example.daggerapp.common.constant.IntentKeyword.CATEGORY_NAME;
import static dagger.android.AndroidInjection.inject;

public class MealCategoryActivity extends AppCompatActivity implements RecyclerViewOnClickListener<MealCategory> {
    ActivityMainBinding binding;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    CategoryMealAdapter adapter;

    @Inject
    MealApiService mealApiService;

    @ActivityContext
    @Inject
    Context activityContext;

    @ApplicationContext
    @Inject
    Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*MyApplication.get(this)
                .getApplicationComponent()
                .getMealCategoryActivityComponentFactory()
                .create(this);*/

        AndroidInjection.inject(this);

        binding.recyclerview.setAdapter(adapter);

        loadCategory();
    }

    private void loadCategory() {
        compositeDisposable.add(
                mealApiService.getCategories()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(result -> adapter.updateData(result.getCategories()))
        );
    }

    @Override
    public void onClickListItem(MealCategory item) {
        Intent intent = new Intent(activityContext, MealByCategoryActivity.class);
        intent.putExtra(CATEGORY_NAME, item.getStrCategory());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}