package ru.bacha.gym;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

import ru.bacha.gym.activity.ExeActivity;
import ru.bacha.gym.activity.MainActivity;
import ru.bacha.gym.model.Exercise;

public class ExerciseAdaptor extends RecyclerView.Adapter<ExerciseAdaptor.ViewHolder> {

    private LayoutInflater inflater;
    List<Exercise> exercises;

    public ExerciseAdaptor(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_exercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdaptor.ViewHolder holder, int position) {
        holder.bind(exercises.get(position));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);

        }

        public void bind(Exercise exercise){
            nameTextView.setText(exercise.name + " " + exercise.id);
            itemView.setOnClickListener(view -> {
                itemView.getContext().startActivity(ExeActivity.createExerciseIntent(itemView.getContext(),
                        exercise));
            });
        }
    }

    public void setExercises(List<Exercise> exercises){
        this.exercises = exercises;
        this.notifyDataSetChanged();
    }
}
