package ru.bacha.gym.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import ru.bacha.gym.model.Workout;

@Dao
public interface WorkoutDao {

    @Query("SELECT * FROM Workout WHERE date = :date")
    Maybe<Workout> getWorkout(String date);

    @Insert
    Single<Long> addWorkout(Workout workout);
}
