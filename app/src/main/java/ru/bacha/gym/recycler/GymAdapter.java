package ru.bacha.gym.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymAdapter extends RecyclerView.Adapter<GymViewHolder> {

    private LayoutInflater inflater;

    public GymAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    private List<ViewHolderProvider> providerList = new ArrayList<>();
    private Map<Integer, ViewHolderProvider> builders = new HashMap<>();

    public void setProviderList(List<ViewHolderProvider> providerList) {
        this.providerList = providerList;
        Map<Integer, ViewHolderProvider> newMap = new HashMap<>();
        for (ViewHolderProvider provider : providerList) {
            newMap.put(provider.getItemViewType(), provider);
        }
        builders = newMap;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return providerList.get(position).getItemViewType();
    }

    @NonNull
    @Override
    public GymViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return builders.get(viewType).createViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull GymViewHolder holder, int position) {
        providerList.get(position).bindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return providerList.size();
    }
}
