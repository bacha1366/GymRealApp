package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ExeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execises);
        Exercise exercise = getIntent().getParcelableExtra(EXERCISE_KEY);

        TextView nameExe = findViewById(R.id.NameExe);
        TextView weightExe = findViewById(R.id.WeightExe);
        TextView replayExe = findViewById(R.id.ReplayExe);
        nameExe.setText(exercise.name);
        weightExe.setText(Double.toString(exercise.weight));
        replayExe.setText(Integer.toString(exercise.replay));
    }

    public static Intent createExerciseIntent(Context context, Exercise exercise) {
        Intent intent = new Intent(context, ExeActivity.class);
        intent.putExtra(EXERCISE_KEY, exercise);
        return intent;
    }

    private static String EXERCISE_KEY = "exercise_key";


}
