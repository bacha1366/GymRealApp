package ru.bacha.gym;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ExercisesManager{

    public List<Approach> approaches = new ArrayList<Approach>();

    private List<Exercise> myExercises = new ArrayList<>();

    ExerciseDataBase db;
    ExerciseDao exerciseDao;

    public ExercisesManager(ExerciseDataBase db){
        this.db = db;
        exerciseDao = db.exerciseDao();
    }


    Single<List<Exercise>> getExercises(){
        return exerciseDao.getAll().doOnSuccess(exercises -> {myExercises = exercises;});
    }


    public Single<Exercise> getExerciseForID(int id) {
        return Observable
                .fromIterable(myExercises)
                .filter(exercise -> {
                    if (id == exercise.id) return true;
                    return false;
                })
                .singleOrError();
    }

    ;

    public Completable saveApproach(int id, double weight, int replay, String note) {
        return Completable
                .fromRunnable(() -> approaches.add(new Approach(id, weight, replay, note)));

    }

    public Observable<List<Approach>> observeApproaches() {
        return null;
    }
}