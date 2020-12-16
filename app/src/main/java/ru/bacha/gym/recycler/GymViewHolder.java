package ru.bacha.gym.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class GymViewHolder extends RecyclerView.ViewHolder {
    public GymViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
