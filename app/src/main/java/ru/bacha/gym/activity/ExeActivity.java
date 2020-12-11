package ru.bacha.gym.activity;

import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.manager.MainManager;
import ru.bacha.gym.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ExeActivity extends BaseActivity implements View.OnClickListener {

    TextView nameExe;
    TextView weightExe;
    TextView replayExe;
    TextView approachExe;
    TextView noteExe;
    MainManager mainManager;
    Exercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execises);
        mainManager = getGymApp().mainManager;
        nameExe = findViewById(R.id.NameExe);
        weightExe = findViewById(R.id.WeightExe);
        replayExe = findViewById(R.id.ReplayExe);
        noteExe = findViewById(R.id.NoteExe);
        approachExe = findViewById(R.id.approachView);
        mainManager
                .getExerciseForID(getIntent().getLongExtra(EXERCISE_KEY, 0))
                .subscribe(exercise -> {
                    nameExe.setText(exercise.name);
                    this.exercise = exercise;
                });
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
        String note;
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
                try {
                    note = noteExe.getText().toString();
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Что то пошло не так", Toast.LENGTH_LONG).show();
                    return;
                }
                mainManager.createApproach(exercise.id, weight, replay, note);

        }
    }
}
