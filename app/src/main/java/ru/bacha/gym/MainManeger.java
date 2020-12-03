package ru.bacha.gym;

import android.app.Application;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class MainManeger {

    ExerciseDataBase db;
    public ExercisesManager mExercisesManager = new ExercisesManager(db);
    public WorkoutManeger mWorkoutManeger = new WorkoutManeger(db);
    public SetManeger mSetManeger = new SetManeger(db);
    public ApproachManeger mApproachManeger = new ApproachManeger(db);

    public MainManeger(ExerciseDataBase db) {
        this.db = db;
    }

    Observable<List<Exercise>> getExercises() {
        return mExercisesManager.getExercises();
    }

    public Single<Exercise> getExerciseForID(Long id) {
        return mExercisesManager.getExerciseForID(id);
    }

    public Single<Long> write(Long idExercise, double weight, int replay, String note) {
        return mWorkoutManeger.getWorkout()
                .map(workout -> {
                    return workout.id;
                })
                .flatMap(idWorkout -> {
                    return mSetManeger.getMySet(idExercise, idWorkout);
                })
                .map(mySet -> {
                    return mySet.id;
                })
                .flatMap(idSet -> {
                    return mApproachManeger.createApproach(idSet, weight, replay, note);
                })
                ;
    }
}
