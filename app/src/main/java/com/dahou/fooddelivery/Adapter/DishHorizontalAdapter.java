package com.dahou.fooddelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dahou.fooddelivery.R;
import com.dahou.fooddelivery.model.DishModel;
import com.dahou.fooddelivery.viewholder.DishViewHolder;

import java.util.ArrayList;

public class DishHorizontalAdapter extends RecyclerView.Adapter<DishViewHolder> {
    Context context;
    ArrayList<DishModel> data;

    public DishHorizontalAdapter(Context context, ArrayList<DishModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_dish,parent,false);

        return new DishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        holder.dishName.setText(data.get(position).getName());
        holder.dishCategory.setText(data.get(position).getCategory());
        holder.dishImage.setImageResource(data.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
