package com.ipro.prototype;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView stuffName;
    TextView stuffDesc;
    TextView stuffLocation;

    MyViewHolder(View view) {
        super(view);

        stuffName = view.findViewById(R.id.stuffName);
        stuffDesc = view.findViewById(R.id.stuffDesc);
        stuffLocation = view.findViewById(R.id.stuffLocation);
    }
}
