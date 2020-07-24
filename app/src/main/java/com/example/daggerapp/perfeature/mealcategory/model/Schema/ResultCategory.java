package com.example.daggerapp.perfeature.mealcategory.model.Schema;

import com.example.daggerapp.perfeature.mealcategory.model.Schema.MealCategory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultCategory {
    @SerializedName("categories")
    @Expose
    private List<MealCategory> categories;

    public List<MealCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<MealCategory> categories) {
        this.categories = categories;
    }
}
