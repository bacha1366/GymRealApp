package ru.bacha.gym.activity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.manager.MainManager;
import ru.bacha.gym.R;
import ru.bacha.gym.recycler.GymAdapter;
import ru.bacha.gym.recycler.ViewHolderProvider;
import ru.bacha.gym.recycler.viewholder.ExerciseViewHolderProvider;
import ru.bacha.gym.recycler.viewholder.TitleViewHolderProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {// Наследуется от BaseActivity для метода getGymApp()


    private MainManager mainManager;
    ArrayAdapter<Exercise> adapter;
    //ExerciseAdaptor exerciseAdaptor;
    GymAdapter gymAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerViewExercises = findViewById(R.id.exercises_list);
        recyclerViewExercises.setLayoutManager(new LinearLayoutManager(this));
        //exerciseAdaptor = new ExerciseAdaptor(this);
        gymAdapter = new GymAdapter(this);
        recyclerViewExercises.setAdapter(gymAdapter);
        FloatingActionButton Button_newExercise = findViewById(R.id.new_btn);
        mainManager = getGymApp().mainManager;
        mainManager.getExercises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(exercises -> {
                    //exerciseAdaptor.setExercises(exercises);
                    List<ViewHolderProvider> providers = new ArrayList<>();
                    providers.add(new TitleViewHolderProvider());
                    for (Exercise exercise : exercises) {
                        providers.add(new ExerciseViewHolderProvider(exercise));
                    }
                    gymAdapter.setProviderList(providers);
        });


        Button_newExercise.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NewExerciseActivity.class)));

    }
}
