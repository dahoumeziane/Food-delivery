package com.dahou.fooddelivery.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dahou.fooddelivery.R;

public class DishViewHolder extends RecyclerView.ViewHolder {
    ImageView dishImage;
    TextView dishName,dishCategory;
    public DishViewHolder(@NonNull View itemView) {
        super(itemView);
        dishImage = itemView.findViewById(R.id.foodImage);
        dishName = itemView.findViewById(R.id.dishName);
        dishCategory = itemView.findViewById(R.id.dishCategory);


    }
}
