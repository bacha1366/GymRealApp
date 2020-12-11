package ru.bacha.gym.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.bacha.gym.dao.WorkoutDao;
import ru.bacha.gym.ExerciseDataBase;
import ru.bacha.gym.model.Workout;

public class WorkoutManager {


    WorkoutDao workoutDao;
    Workout cache;

    public WorkoutManager(ExerciseDataBase db){
        workoutDao = db.workoutDao();
    }

    public Single<Workout> getWorkout() {
        if (cache == null) {
            return workoutDao.getWorkout(nDate())
                    .switchIfEmpty(createWorkout())
                    .doOnSuccess(workout -> cache = workout)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else return Single.just(cache);
    }

    public Single<Workout> createWorkout() {
        return workoutDao.addWorkout(new Workout(nDate())).map(id -> new Workout(id, nDate()));
    }


    private String nDate(){
        return (new SimpleDateFormat("YYYY-MM-DD")).format(new Date());
    }
}
