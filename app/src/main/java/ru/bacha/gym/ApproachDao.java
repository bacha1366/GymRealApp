package ru.bacha.gym;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface ApproachDao {

    @Insert
    Single<Long> addAproach(Long idSet, double weight, int replay, String note);

    @Query("SELECT * FROM Approach WHERE idSet = :idSet")
    Maybe<List<Approach>> getApproach(Long idSet);

}
