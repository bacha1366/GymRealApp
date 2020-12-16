package ru.bacha.gym.recycler.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import ru.bacha.gym.R;
import ru.bacha.gym.recycler.GymViewHolder;
import ru.bacha.gym.recycler.ViewHolderProvider;

public class TitleViewHolderProvider implements ViewHolderProvider {
    @Override
    public GymViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_item_header, parent, false);
        return new TitleViewHolderA(view);
    }

    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public void bindViewHolder(GymViewHolder holder) {

    }
}

class TitleViewHolderA extends GymViewHolder {
    public TitleViewHolderA(@NonNull View itemView) {
        super(itemView);

    }
}
