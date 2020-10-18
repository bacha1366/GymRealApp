package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ExeActivity extends AppCompatActivity {

    private static String EXERCISE_KEY = "exercise_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execises);
        ExeClass exeClass = (ExeClass) getIntent().getParcelableExtra(EXERCISE_KEY);

        TextView nameExe = (TextView) findViewById(R.id.NameExe);
        TextView weightExe = (TextView) findViewById(R.id.WeightExe);
        TextView replayExe = (TextView) findViewById(R.id.ReplayExe);
        nameExe.setText(exeClass.name);
        weightExe.setText(Double.toString(exeClass.weight));
        replayExe.setText(Integer.toString(exeClass.replay));
    }


}
