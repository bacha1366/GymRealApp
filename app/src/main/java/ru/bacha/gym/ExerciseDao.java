package ru.bacha.gym;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM Exercise")
    Single<List<Exercise>> getAll();

    @Insert
    Single<Long> addExercise(Exercise exercise);

}