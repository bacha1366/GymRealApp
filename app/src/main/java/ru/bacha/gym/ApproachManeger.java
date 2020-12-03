package ru.bacha.gym;

import io.reactivex.rxjava3.core.Single;

public class ApproachManeger {

    ExerciseDataBase db;
    ApproachDao approachDao;

    public ApproachManeger(ExerciseDataBase db){
        this.db = db;
        approachDao = db.approachDao();
    }

    public Single<Long> createApproach(Long idSet, double weight, int replay, String note){
        return approachDao.addAproach(idSet, weight, replay, note);
    }
}
