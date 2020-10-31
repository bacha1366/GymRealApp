package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.rxjava3.functions.Consumer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends BaseActivity {


    private ExercisesManager exercisesManager;
    ArrayAdapter<Exercise> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listexercises = (ListView) findViewById(R.id.IDlist);
        exercisesManager = getGymApp().mExercisesManager ;
        exercisesManager.getMyExercises().subscribe(new Consumer<List<Exercise>>() {
            @Override
            public void accept(List<Exercise> exercises) throws Throwable {
                adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        exercises) ;
                listexercises.setAdapter(adapter);
            }
        });

        listexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(ExeActivity.createExerciseIntent(MainActivity.this,
                        adapter.getItem(position)));
            }
        });

    }
}
