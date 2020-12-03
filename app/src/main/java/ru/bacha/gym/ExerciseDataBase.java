package ru.bacha.gym;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Exercise.class, Workout.class, MySet.class, Approach.class}, version = 1)
public abstract class ExerciseDataBase extends RoomDatabase { //Создаем класс базы данных
    public abstract ExerciseDao exerciseDao(); //Поле класса - объект Dao
    public abstract WorkoutDao workoutDao();
    public abstract SetDao setDao();
    public abstract ApproachDao approachDao();

}
