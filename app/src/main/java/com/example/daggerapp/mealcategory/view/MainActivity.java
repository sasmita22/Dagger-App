package com.example.daggerapp.mealcategory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.example.daggerapp.MyApplication;
import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.common.network.MealApiService;
import com.example.daggerapp.common.schema.Result;
import com.example.daggerapp.databinding.ActivityMainBinding;
import com.example.daggerapp.di.component.MainActivityComponent;
import com.example.daggerapp.di.module.MainActivityModule;
import com.example.daggerapp.di.qualifier.ActivityContext;
import com.example.daggerapp.di.qualifier.ApplicationContext;
import com.example.daggerapp.mealcategory.model.Schema.MealCategory;
import com.example.daggerapp.mealcategory.view.adapter.CategoryMealAdapter;
import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClickListener {
    MainActivityComponent mainActivityComponent;
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

        mainActivityComponent = MyApplication.get(this)
                .getApplicationComponent()
                .getMainActivityComponentBuilder()
                .mainActivity(this)
                .build();
        mainActivityComponent.inject(this);

        binding.recyclerview.setAdapter(adapter);

        loadCategory();
    }

    private void loadCategory() {
        compositeDisposable.add(
                mealApiService.getCategories()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMapIterable((Function<Result, Iterable<MealCategory>>) Result::getCategories)
                        .filter(mealCategory -> mealCategory.getStrCategory().substring(0,1).equalsIgnoreCase("P"))
                        .toList()
                        .subscribe(mealCategories -> adapter.updateData(mealCategories))
        );
    }

    @Override
    public void onClickListItem(MealCategory mealCategory) {
        Toast.makeText(this, mealCategory.getStrCategory(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}