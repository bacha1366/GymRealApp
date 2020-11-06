package ru.bacha.gym;

import android.app.Application;

import androidx.room.Room;

public class GymApp extends Application {

    public ExercisesManager mExercisesManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mExercisesManager = new ExercisesManager();

    }

    public ExerciseDataBase getDB(){
        return Room.databaseBuilder(this, ExerciseDataBase.class, "ExerciseDataBase")
                .build();
    }




}
