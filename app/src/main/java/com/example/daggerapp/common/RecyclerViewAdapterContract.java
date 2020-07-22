package com.example.daggerapp.common;

import android.app.Activity;

import com.example.daggerapp.common.listener.RecyclerViewOnClickListener;

public interface RecyclerViewAdapterContract<T> {
    void updateData(T data);
}
