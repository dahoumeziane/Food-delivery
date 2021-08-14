package com.dahou.fooddelivery.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.dahou.fooddelivery.R;
import com.dahou.fooddelivery.model.DishModel;
import com.dahou.fooddelivery.viewholder.DishVerticalViewHolder;

import java.util.ArrayList;

public class DishVerticalAdapter extends RecyclerView.Adapter<DishVerticalViewHolder> {
    Context context;
    ArrayList<DishModel> data;

    public DishVerticalAdapter(Context context, ArrayList<DishModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public DishVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_dish_withadress,parent,false);

        return new DishVerticalViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull DishVerticalViewHolder holder, int position) {
        holder.dishTitle.setText(data.get(position).getName());
        holder.dishAddress.setText(data.get(position).getAddress());
        holder.dishType.setText(data.get(position).getCategory());
        holder.dishImage.setImageResource(data.get(position).getImage());
        if (data.get(position).isOpen()){
            holder.dishStatus.setText("Open");
            holder.dishStatus.setTextColor(context.getColor(R.color.green));
            holder.statusIcon.setImageResource(R.drawable.green_circle);
        }else {
            //hide an element
            //holder.itemView.setLayoutParams(new ConstraintLayout.LayoutParams(0, 0));
            //holder.itemView.setVisibility(View.GONE);
            holder.dishStatus.setText("Close");
            holder.dishStatus.setTextColor(context.getColor(R.color.red));
            holder.statusIcon.setImageResource(R.drawable.red_circle);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
