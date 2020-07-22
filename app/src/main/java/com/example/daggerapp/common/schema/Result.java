package com.example.daggerapp.common.schema;

import com.example.daggerapp.mealcategory.model.Schema.MealCategory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
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
