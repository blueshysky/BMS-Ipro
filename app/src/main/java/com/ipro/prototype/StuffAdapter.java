package com.ipro.prototype;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StuffAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ImageView mImageView;
    private List<Stuff> stuffList;
    private MainActivity mainAct;
    private static final String TAG = "StuffAdapter";

    StuffAdapter(List<Stuff> stuffList, MainActivity main) {
        this.stuffList = stuffList;
        this.mainAct = main;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.stuffrow, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Stuff stuff = stuffList.get(position);
        holder.stuffName.setText(stuff.getName());
        holder.stuffDesc.setText(stuff.getDesc());
        holder.stuffLocation.setText(stuff.getLocation());

    }

    @Override
    public int getItemCount() {
        return stuffList.size();
    }
}
