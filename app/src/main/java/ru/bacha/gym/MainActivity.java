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

    private ExeClass[] mExeClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExeClass = new ExeClass[10];
        for (int i = 0; i < mExeClass.length; i++) {
            mExeClass[i].Name = "Execyses " + i;
        }
        ListView listexercises = (ListView) findViewById(R.id.IDlist);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, mExeClass);
        listexercises.setAdapter(adapter);
        listexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ExeActivity.class);
            }
        });

    }
}
