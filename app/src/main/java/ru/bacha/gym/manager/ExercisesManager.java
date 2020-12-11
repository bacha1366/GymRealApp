package ru.bacha.gym.manager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import ru.bacha.gym.dao.ExerciseDao;
import ru.bacha.gym.model.Exercise;
import ru.bacha.gym.ExerciseDataBase;

public class ExercisesManager{

    private List<Exercise> myExercises = new ArrayList<>();

    ExerciseDao exerciseDao;


    public ExercisesManager(ExerciseDataBase db){
        exerciseDao = db.exerciseDao();
    }


    Observable<List<Exercise>> getExercises(){
        return exerciseDao.getAll().doOnNext(exercises -> {myExercises = exercises;});
    }

    public Single<Exercise> getExerciseForID(long id) {
        return Observable
                .fromIterable(myExercises)
                .filter(exercise -> {
                    if (id == exercise.id) return true;
                    return false;
                })
                .singleOrError();
    }

    public Completable addExercise(String name){
        return exerciseDao.addExercise(new Exercise(name));
    }

}
