package ru.bacha.gym.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import ru.bacha.gym.model.Approach;

@Dao
public interface ApproachDao {

    @Insert
    Single<Long> addApproach(Approach approach);

    @Query("SELECT * FROM Approach WHERE idSet = :idSet")
    Maybe<List<Approach>> getApproach(Long idSet);

}
