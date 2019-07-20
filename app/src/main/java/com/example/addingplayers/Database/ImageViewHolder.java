package com.example.addingplayers.Database;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.addingplayers.R;
import com.thesurix.gesturerecycler.GestureViewHolder;

import org.jetbrains.annotations.NotNull;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView,edit,drag;
    public TextView textView;
    public ImageViewHolder(@NotNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        textView = itemView.findViewById(R.id.textview);
        edit = itemView.findViewById(R.id.edit_Btn);
        drag = itemView.findViewById(R.id.drap_Btn);
    }
}
