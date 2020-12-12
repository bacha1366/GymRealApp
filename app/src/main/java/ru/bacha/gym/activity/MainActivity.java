package ru.bacha.gym.activity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.bacha.gym.ExerciseAdaptor;
import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.manager.MainManager;
import ru.bacha.gym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity {// Наследуется от BaseActivity для метода getGymApp()


    private MainManager mainManager;
    ArrayAdapter<Exercise> adapter;
    ExerciseAdaptor exerciseAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerViewExercises = findViewById(R.id.exercises_list);
        recyclerViewExercises.setLayoutManager(new LinearLayoutManager(this));
        exerciseAdaptor = new ExerciseAdaptor(this);
        recyclerViewExercises.setAdapter(exerciseAdaptor);
        FloatingActionButton Button_newExercise = findViewById(R.id.new_btn);
        mainManager = getGymApp().mainManager;
        mainManager.getExercises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(exercises -> {
                    exerciseAdaptor.setExercises(exercises);

        });


        Button_newExercise.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NewExerciseActivity.class)));

    }
}
