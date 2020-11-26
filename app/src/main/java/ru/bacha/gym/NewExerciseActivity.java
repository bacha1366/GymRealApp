package ru.bacha.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewExerciseActivity extends BaseActivity {// Наследуется от BaseActivity для метода getGymApp()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise);
        ExerciseDataBase db = getGymApp().getDB(); //Создаем переменную и получаем объект базы данных
        ExerciseDao exerciseDao = db.exerciseDao();
        TextView nameExe = (TextView) findViewById(R.id.NameExe);
        Button addBtn = (Button) findViewById(R.id.new_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exerciseDao.addExercise(new Exercise(null, nameExe.getText().toString()))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe();
            }
        });
    }

}
