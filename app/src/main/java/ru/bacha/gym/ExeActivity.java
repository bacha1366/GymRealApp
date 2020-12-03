package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observer;

public class ExeActivity extends BaseActivity implements View.OnClickListener {

    private MainManeger mainManeger;
    TextView nameExe;
    TextView weightExe;
    TextView replayExe;
    TextView approachExe;
    TextView noteExe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execises);
        mainManeger = getGymApp().mainManeger;
        nameExe = findViewById(R.id.NameExe);
        weightExe = findViewById(R.id.WeightExe);
        replayExe = findViewById(R.id.ReplayExe);
        noteExe = findViewById(R.id.NoteExe);
        approachExe = findViewById(R.id.approachView);
        mainManeger
                .getExerciseForID(getIntent().getLongExtra(EXERCISE_KEY, 0))
                .subscribe(exercise -> {
                    nameExe.setText(exercise.name);
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



        }
    }
}
