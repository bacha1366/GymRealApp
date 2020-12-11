package ru.bacha.gym.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import ru.bacha.gym.model.Exercise;

@Dao
public interface ExerciseDao {

    @Query("SELECT * FROM Exercise")
    Observable<List<Exercise>> getAll();

    @Insert
    Completable addExercise(Exercise exercise);

}