package ru.bacha.gym.manager;

import io.reactivex.rxjava3.core.Single;
import ru.bacha.gym.dao.SetDao;
import ru.bacha.gym.ExerciseDataBase;
import ru.bacha.gym.model.MySet;

public class SetManager {

    private SetDao setDao;

    public SetManager(ExerciseDataBase db){
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
