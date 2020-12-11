package ru.bacha.gym;

import android.app.Application;

import androidx.room.Room;

import ru.bacha.gym.manager.MainManager;

public class GymApp extends Application {

    public MainManager mainManager;

    @Override
    public void onCreate() {
        super.onCreate();
        ExerciseDataBase exerciseDataBase = Room.databaseBuilder(this, ExerciseDataBase.class, "ExerciseDataBase")
                .build();
        mainManager = new MainManager(exerciseDataBase);

    }





}
