package ru.bacha.gym.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.bacha.gym.manager.MainManager;
import ru.bacha.gym.R;

public class NewExerciseActivity extends BaseActivity {// Наследуется от BaseActivity для метода getGymApp()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise);
        TextView nameExe = findViewById(R.id.NameExe);
        Button addBtn = findViewById(R.id.new_btn);
        MainManager mainManager = getGymApp().mainManager;
        addBtn.setOnClickListener(view -> {
            mainManager.addExercise(nameExe.getText().toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe();
            finish();
        });
    }
}

