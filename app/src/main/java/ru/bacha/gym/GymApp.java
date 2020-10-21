package ru.bacha.gym;

import android.app.Application;

public class GymApp extends Application {

    public ExercisesManager mExercisesManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mExercisesManager = new ExercisesManager();
    }
}
