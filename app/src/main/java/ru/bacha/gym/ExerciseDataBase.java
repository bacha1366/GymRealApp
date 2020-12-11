package ru.bacha.gym;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.bacha.gym.model.Approach;
import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.model.MySet;
import ru.bacha.gym.model.Workout;
import ru.bacha.gym.dao.ApproachDao;
import ru.bacha.gym.dao.ExerciseDao;
import ru.bacha.gym.dao.SetDao;
import ru.bacha.gym.dao.WorkoutDao;


@Database(entities = {Exercise.class, Workout.class, MySet.class, Approach.class}, version = 1)
public abstract class ExerciseDataBase extends RoomDatabase { //Создаем класс базы данных
    public abstract ExerciseDao exerciseDao(); //Поле класса - объект Dao
    public abstract WorkoutDao workoutDao();
    public abstract SetDao setDao();
    public abstract ApproachDao approachDao();

}
