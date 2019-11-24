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
    private OnListItemClickListener mOnListItemClickListener;


    public YogaPosesAdapter(ArrayList<YogaPose> poses, OnListItemClickListener listener) {
        this.poses = poses;
        mOnListItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_single_item, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        final YogaPose pose = poses.get(position);
        viewHolder.bind(pose);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current state of the item
                boolean expanded = pose.isExpanded();
                // Change the state
                pose.setExpanded(!expanded);
                // Notify the adapter that item has changed
                YogaPosesAdapter.this.notifyItemChanged(position);
            }
        });

    }

    public int getItemCount() {
        return poses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView icon;
        TextView subItem;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
            subItem = itemView.findViewById(R.id.subItem);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }

        private void bind(YogaPose pose) {
            // Get the state
            boolean expanded = pose.isExpanded();
            // Set the visibility based on state
            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

            name.setText(pose.getName());
            icon.setImageResource(pose.getIconId());
            subItem.setText(pose.getDescription());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
