package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity {


    private ExercisesManager exercisesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exercisesManager = getGymApp().mExercisesManager ;
        ListView listexercises = findViewById(R.id.IDlist);
        final ArrayAdapter<Exercise> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, exercisesManager.getMyExercises()) ;
        listexercises.setAdapter(adapter);
        listexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(ExeActivity.createExerciseIntent(MainActivity.this,
                        adapter.getItem(position)));
            }
        });

    }
}
