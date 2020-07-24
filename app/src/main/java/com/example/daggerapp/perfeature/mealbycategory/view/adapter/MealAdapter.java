package com.example.daggerapp.perfeature.mealbycategory.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daggerapp.common.contract.RecyclerViewAdapterContract;
import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.databinding.ItemCategoryBinding;
import com.example.daggerapp.di.qualifier.ActivityContext;
import com.example.daggerapp.perfeature.mealbycategory.model.schema.Meal;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder>
implements RecyclerViewAdapterContract<List<Meal>> {
    private final RecyclerViewOnClickListener<Meal> listener;
    private List<Meal> meals;

    @ActivityContext
    @Inject
    Context context;

    @Inject
    public MealAdapter(RecyclerViewOnClickListener<Meal> listener) {
        this.listener = listener;
        this.meals = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(meals.get(position).getStrMealThumb())
                .centerCrop()
                .into(holder.binding.imageView);
        holder.binding.title.setText(meals.get(position).getStrMeal());
        holder.binding.getRoot().setOnClickListener(view -> listener.onClickListItem(meals.get(position)));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    @Override
    public void updateData(List<Meal> data) {
        meals = new ArrayList<>(data);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding binding;
        public ViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
