package com.example.projectlabux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    ArrayList<Integer> items;

    public MyAdapter(ArrayList<Integer> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_assets,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.getAsset1().setBackgroundResource(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    private ImageView asset1;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        asset1 = itemView.findViewById(R.id.asset1);
    }

    public void setAsset1(ImageView asset1) {
        this.asset1 = asset1;
    }

    public ImageView getAsset1() {
        return asset1;
    }
}

