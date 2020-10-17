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

    public String exemass[] = new String[10];
    public ExeClass mExeClasses[] = new ExeClass[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10; i++) {
            exemass[i] = "Execyses " + (i + 1);
            mExeClasses[i].Name = "Execyses " + (i + 1);
            mExeClasses[i].weight = (int) Math.random() * 100;
        }
        ListView listexercises = (ListView) findViewById(R.id.IDlist);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, exemass);
        listexercises.setAdapter(adapter);
        listexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ExeActivity.class);
            }
        });

    }
}
