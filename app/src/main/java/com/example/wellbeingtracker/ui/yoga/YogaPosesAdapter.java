package com.example.wellbeingtracker.ui.yoga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wellbeingtracker.Model.YogaPose;
import com.example.wellbeingtracker.R;

import java.util.ArrayList;

class YogaPosesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<YogaPosesAdapter.ViewHolder> {

    private ArrayList<YogaPose> poses;

    public YogaPosesAdapter(ArrayList<YogaPose> poses) {
        this.poses = poses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_single_item, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(poses.get(position).getName());
        viewHolder.icon.setImageResource(poses.get(position).getIconId());
    }

    public int getItemCount() {
        return poses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
        }
}
}
