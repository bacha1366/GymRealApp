package ru.bacha.gym;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface WorkoutDao {

    @Query("SELECT * FROM Workout WHERE mydate = date('now')")
    Maybe<Workout> getWorkout();

    @Insert
    Single<Long> addWorkout(Workout workout);
}
