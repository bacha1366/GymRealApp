package ru.bacha.gym;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface SetDao {

    @Query("SELECT * FROM MySet WHERE idExercise = :idExercise AND idWorkout = :idWorkout")
    Maybe<MySet> getMySet (Long idExercise, Long idWorkout);

    @Insert
    Single<Long> addMySet(MySet mySet);
}
