package ru.bacha.gym.activity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.manager.MainManager;
import ru.bacha.gym.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity {// Наследуется от BaseActivity для метода getGymApp()


    private MainManager mainManager;
    ArrayAdapter<Exercise> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listexercises = findViewById(R.id.IDlist);
        FloatingActionButton newExercise = findViewById(R.id.new_btn);
        mainManager = getGymApp().mainManager;
        adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1) ;
        listexercises.setAdapter(adapter);
        mainManager.getExercises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(exercises -> {
                    adapter.clear();
                    adapter.addAll(exercises);

        });

        listexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(ExeActivity.createExerciseIntent(MainActivity.this,
                        adapter.getItem(position)));
            }
        });

        newExercise.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NewExerciseActivity.class)));

    }
}
