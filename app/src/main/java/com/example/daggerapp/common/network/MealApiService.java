package com.example.daggerapp.common.network;

import com.example.daggerapp.perfeature.mealbycategory.model.schema.ResultMeal;
import com.example.daggerapp.perfeature.mealcategory.model.Schema.ResultCategory;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealApiService {
    @GET("categories.php")
    Observable<ResultCategory> getCategories();

    @GET("filter.php")
    Observable<ResultMeal> getMeals(@Query("c") String categoryName);
}
