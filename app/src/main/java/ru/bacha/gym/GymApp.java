package ru.bacha.gym;

import android.app.Application;

import androidx.room.Room;

public class GymApp extends Application {

    public ExercisesManager mExercisesManager;
    public WorkoutManeger mWorkoutManeger;
    public SetManeger mSetManeger;
    private ExerciseDataBase exerciseDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        exerciseDataBase = Room.databaseBuilder(this, ExerciseDataBase.class, "ExerciseDataBase")
                .build();
        mExercisesManager = new ExercisesManager(getDB());
        mWorkoutManeger = new WorkoutManeger(getDB());
    }

    public ExerciseDataBase getDB(){
        return exerciseDataBase;
    }




}
