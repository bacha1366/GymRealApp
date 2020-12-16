package ru.bacha.gym.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface ViewHolderProvider {
    GymViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent);
    int getItemViewType();
    void bindViewHolder(GymViewHolder holder);
}
