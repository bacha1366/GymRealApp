package ru.bacha.gym;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.bacha.gym.activity.ExeActivity;
import ru.bacha.gym.model.Exercise;

public class ExerciseAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    List<Exercise> exercises = new ArrayList<>();

    public ExerciseAdaptor(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ElementType.HEADER.ordinal();
        } else {
            return ElementType.ELEMENT.ordinal();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ElementType type = ElementType.values()[viewType];
        return type.createViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).bind();
        } else if (holder instanceof ExerciseViewHolder) {
            ((ExerciseViewHolder) holder).bind(exercises.get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return exercises.size() + 1;
    }



    public void setExercises(List<Exercise> exercises){
        this.exercises = exercises;
        notifyDataSetChanged();
    }
}

class ExerciseViewHolder extends RecyclerView.ViewHolder {
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

class TitleViewHolder extends RecyclerView.ViewHolder {
    public TitleViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    public void bind(){
    }
}

enum ElementType {
    HEADER {
        @Override
        RecyclerView.ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
            View view = inflater.inflate(R.layout.list_item_header, parent, false);
            return new TitleViewHolder(view);
        }
    },
    ELEMENT {
        @Override
        RecyclerView.ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
            View view = inflater.inflate(R.layout.list_item_exercise, parent,false);
            return new ExerciseViewHolder(view);
        }
    };

    abstract RecyclerView.ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent);
}
