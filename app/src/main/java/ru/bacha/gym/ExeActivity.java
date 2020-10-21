package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ExeActivity extends BaseActivity implements View.OnClickListener {

    private ExercisesManager exercisesManager;
    private Exercise exercise;
    TextView weightExe;
    TextView replayExe;
    TextView approachExe;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execises);
        exercisesManager = getGymApp().mExercisesManager ;
        id=1;
        exercise = exercisesManager.getExerciseForID(getIntent().getIntExtra(EXERCISE_KEY,
                0));
        TextView nameExe = findViewById(R.id.NameExe);
        weightExe = findViewById(R.id.WeightExe);
        replayExe = findViewById(R.id.ReplayExe);
        approachExe = findViewById(R.id.approachView);
        nameExe.setText(exercise.name);
    }

    public static Intent createExerciseIntent(Context context, Exercise exercise) {
        Intent intent = new Intent(context, ExeActivity.class);
        intent.putExtra(EXERCISE_KEY, exercise.id);
        return intent;
    }

    private static String EXERCISE_KEY = "exercise_key";


    @Override
    public void onClick(View view) {
        double weight;
        int replay;
        switch (view.getId()) {
            case R.id.nextButton:
                try {
                    weight = Double.parseDouble(weightExe.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Проверь вес", Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    replay = Integer.parseInt(replayExe.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Проверь количество", Toast.LENGTH_LONG).show();
                    return;
                }
                exercisesManager.saveApproach(id, weight,replay);
                id++;
                approachExe.setText(approachExe.getText() + " " + weight + "*" + replay + " ," );


        }
    }
}
