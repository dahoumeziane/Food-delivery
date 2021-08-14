package com.dahou.fooddelivery.viewholder;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dahou.fooddelivery.R;

public class DishVerticalViewHolder extends RecyclerView.ViewHolder {
    public ImageView dishImage,statusIcon;
    public TextView dishTitle,dishType,dishAddress,dishStatus;
    public DishVerticalViewHolder(@NonNull View itemView) {
        super(itemView);
        dishTitle=itemView.findViewById(R.id.dish_title);
        statusIcon=itemView.findViewById(R.id.status_icon);
        dishImage=itemView.findViewById(R.id.dish_image);
        dishType=itemView.findViewById(R.id.dish_type);
        dishAddress=itemView.findViewById(R.id.dish_address);
        dishStatus=itemView.findViewById(R.id.dish_status);
    }
}
