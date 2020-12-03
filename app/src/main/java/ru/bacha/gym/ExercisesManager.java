package ru.bacha.gym;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ExercisesManager{

    private List<Exercise> myExercises = new ArrayList<>();

    ExerciseDataBase db;
    ExerciseDao exerciseDao;
    private Exercise exercise;


    public ExercisesManager(ExerciseDataBase db){
        this.db = db;
        exerciseDao = db.exerciseDao();
    }


    Observable<List<Exercise>> getExercises(){
        return exerciseDao.getAll().doOnNext(exercises -> {myExercises = exercises;});
    }

    public Single<Exercise> getExerciseForID(Long id) {
        return Observable
                .fromIterable(myExercises)
                .filter(exercise -> {
                    if (id == exercise.id) return true;
                    return false;
                })
                .doOnNext(exercise -> this.exercise = exercise)
                .singleOrError();
    }

}
