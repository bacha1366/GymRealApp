package ru.bacha.gym;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WorkoutManeger {


    ExerciseDataBase db;
    WorkoutDao workoutDao;
    Workout cache;

    public WorkoutManeger(ExerciseDataBase db){
        this.db = db;
        workoutDao = db.workoutDao();
    }

    public Single<Workout> getWorkout() {
        if (cache == null) {
            return workoutDao.getWorkout()
                    .switchIfEmpty(createWorkout())
                    .doOnSuccess(workout -> cache = workout)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else return Single.just(cache);
    }

    public Single<Workout> createWorkout() {
        return workoutDao.addWorkout(new Workout()).map(id -> new Workout(id));
    }
}
