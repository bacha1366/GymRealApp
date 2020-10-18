package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExercisesManager exercisesManager = new ExercisesManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listexercises = findViewById(R.id.IDlist);
        ArrayAdapter<ExeClass> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, exercisesManager.getMyExercises());
        listexercises.setAdapter(adapter);
        listexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, ExeActivity.class);
            }
        });

    }
}
