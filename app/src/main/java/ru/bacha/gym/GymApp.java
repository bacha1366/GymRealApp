package ru.bacha.gym;

import android.app.Application;

import androidx.room.Room;

public class GymApp extends Application {

    public ExercisesManager mExercisesManager;
    public MainManeger mainManeger;
    private ExerciseDataBase exerciseDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        exerciseDataBase = Room.databaseBuilder(this, ExerciseDataBase.class, "ExerciseDataBase")
                .build();
        mainManeger = new MainManeger(getDB());

    }

    public ExerciseDataBase getDB(){
        return exerciseDataBase;
    }




}
