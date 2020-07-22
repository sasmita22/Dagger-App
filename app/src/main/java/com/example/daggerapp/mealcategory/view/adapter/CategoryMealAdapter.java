package com.example.daggerapp.mealcategory.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daggerapp.R;
import com.example.daggerapp.common.RecyclerViewAdapterContract;
import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;
import com.example.daggerapp.mealcategory.model.Schema.MealCategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryMealAdapter extends RecyclerView.Adapter<CategoryMealAdapter.ViewHolder>
implements RecyclerViewAdapterContract<List<MealCategory>> {
    List<MealCategory> mealCategories;
    RecyclerViewOnClickListener listener;
    Context context;

    public CategoryMealAdapter(RecyclerViewOnClickListener listener) {
        this.mealCategories = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(mealCategories.get(position).getStrCategoryThumb())
                .centerCrop()
                .into(holder.imageView);
        holder.title.setText(mealCategories.get(position).getStrCategory());
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
        ImageView imageView;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
