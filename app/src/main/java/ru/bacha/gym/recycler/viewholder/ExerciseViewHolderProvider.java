package ru.bacha.gym.recycler.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import ru.bacha.gym.R;
import ru.bacha.gym.activity.ExeActivity;
import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.recycler.GymViewHolder;
import ru.bacha.gym.recycler.ViewHolderProvider;

public class ExerciseViewHolderProvider implements ViewHolderProvider {

    private Exercise exercise;

    public ExerciseViewHolderProvider(Exercise exercise) {
        this.exercise = exercise;
    }
    @Override
    public GymViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_item_exercise, parent,false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public void bindViewHolder(GymViewHolder holder) {
        ((ExerciseViewHolder) holder).bind(exercise);
    }
}


class ExerciseViewHolder extends GymViewHolder {
    private final TextView nameTextView;
    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);

    }

    public void bind(Exercise exercise){
        nameTextView.setText(exercise.name);
        itemView.setOnClickListener(view -> {
            itemView.getContext().startActivity(ExeActivity.createExerciseIntent(itemView.getContext(),
                    exercise));
        });
    }
}