package com.example.daggerapp.perfeature.mealcategory.view.adapter;

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
import com.example.daggerapp.perfeature.mealcategory.model.Schema.MealCategory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CategoryMealAdapter extends RecyclerView.Adapter<CategoryMealAdapter.ViewHolder>
implements RecyclerViewAdapterContract<List<MealCategory>> {
    List<MealCategory> mealCategories;
    RecyclerViewOnClickListener<MealCategory> listener;

    @ActivityContext
    @Inject
    Context context;

    @Inject
    public CategoryMealAdapter(RecyclerViewOnClickListener<MealCategory> listener) {
        this.mealCategories = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(context), parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MealCategory mealCategory = mealCategories.get(position);
        Glide.with(context)
                .load(mealCategory.getStrCategoryThumb())
                .centerCrop()
                .into(holder.binding.imageView);
        holder.binding.title.setText(mealCategories.get(position).getStrCategory());
        holder.binding.getRoot().setOnClickListener(view -> listener.onClickListItem(mealCategory));
    }

    @Override
    public int getItemCount() {
        return mealCategories.size();
    }

    @Override
    public void updateData(List<MealCategory> data) {
        this.mealCategories = new ArrayList<>(data);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ItemCategoryBinding binding;
        public ViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
