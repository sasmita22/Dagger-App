package com.example.daggerapp.common.network;

import com.example.daggerapp.common.schema.Result;
import com.example.daggerapp.mealcategory.model.Schema.MealCategory;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface MealApiService {
    @GET("categories.php")
    Observable<Result> getCategories();
}
