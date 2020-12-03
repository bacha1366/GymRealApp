package ru.bacha.gym;

import io.reactivex.rxjava3.core.Single;

public class SetManeger {

    ExerciseDataBase db;
    SetDao setDao;
    MySet mySet;

    public SetManeger(ExerciseDataBase db){
        this.db = db;
        setDao = db.setDao();
    }

    public Single<MySet> getMySet(Long idExercise, Long idWorkout){
        return setDao.getMySet(idExercise, idWorkout)
                .switchIfEmpty(createMySet(idExercise, idWorkout));
    }

    public Single<MySet> createMySet(Long idExercise, Long idWorkout){
        return setDao.addMySet(new MySet(idExercise, idWorkout))
                .map(id -> new MySet(id, idExercise, idWorkout));
    }

}
