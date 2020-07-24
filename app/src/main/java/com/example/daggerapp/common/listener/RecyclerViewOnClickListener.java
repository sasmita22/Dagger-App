package com.example.daggerapp.common.listener;

import com.example.daggerapp.perfeature.mealcategory.model.Schema.MealCategory;

public interface RecyclerViewOnClickListener<T> {
    void onClickListItem(T item);
}
