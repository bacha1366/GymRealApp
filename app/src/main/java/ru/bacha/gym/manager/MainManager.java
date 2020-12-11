package ru.bacha.gym.manager;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.ExerciseDataBase;

public class MainManager {

    private ExerciseDataBase db;
    private ExercisesManager mExercisesManager = new ExercisesManager(db);
    private WorkoutManager mWorkoutManager = new WorkoutManager(db);
    private SetManager mSetManager = new SetManager(db);
    private ApproachManager mApproachManager = new ApproachManager(db);

    public MainManager(ExerciseDataBase db) {
        this.db = db;
    }

    public Observable<List<Exercise>> getExercises() {
        return mExercisesManager.getExercises();
    }

    public Single<Exercise> getExerciseForID(Long id) {
        return mExercisesManager.getExerciseForID(id);
    }

    public Single<Long> createApproach(Long idExercise, double weight, int replay, String note) {
        return mWorkoutManager.getWorkout()
                .map(workout -> {
                    return workout.id;
                })
                .flatMap(idWorkout -> {
                    return mSetManager.getMySet(idExercise, idWorkout);
                })
                .map(mySet -> mySet.id)
                .flatMap(idSet -> {
                    return mApproachManager.createApproach(idSet, weight, replay, note);
                })
                ;
    }

    public Completable addExercise(String name){
        return mExercisesManager.addExercise(name);
    }
}
