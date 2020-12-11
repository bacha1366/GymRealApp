package ru.bacha.gym.manager;

import io.reactivex.rxjava3.core.Single;
import ru.bacha.gym.ExerciseDataBase;
import ru.bacha.gym.dao.ApproachDao;
import ru.bacha.gym.model.Approach;

public class ApproachManager {

    ApproachDao approachDao;

    public ApproachManager(ExerciseDataBase db){
        approachDao = db.approachDao();
    }

    public Single<Long> createApproach(Long idSet, double weight, int replay, String note){
        return approachDao.addApproach(new Approach(idSet, weight, replay, note));
    }
}
