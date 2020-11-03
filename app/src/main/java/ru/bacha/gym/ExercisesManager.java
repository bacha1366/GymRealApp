package ru.bacha.gym;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;

public class ExercisesManager {

    public List<Approach> approaches = new ArrayList<Approach>();

    private List <Exercise> myExercises = new ArrayList<>();

    public List<Exercise> loadExercises() {
        myExercises.add(new Exercise(1,"Жим лежа"));
        myExercises.add(new Exercise(2,"Батерфляй"));
        myExercises.add(new Exercise(3,"Кроссовер"));
        myExercises.add(new Exercise(4,"Разводка"));
        myExercises.add(new Exercise(5,"Приседания"));
        myExercises.add(new Exercise(6,"Гак"));
        myExercises.add(new Exercise(7,"Передние дельты"));
        myExercises.add(new Exercise(8,"Разводка сидя"));
        myExercises.add(new Exercise(9,"Трицепц"));
        myExercises.add(new Exercise(10,"Бицепц"));
        return myExercises;
    }



    public Single<List<Exercise>> getMyExercises() {
        return Observable.just(loadExercises())
                .singleOrError();
    };


        public Single<Exercise> getExerciseForID(int id) {
            return Observable
                .fromIterable(myExercises)
                .filter( exercise -> {
                    if (id == exercise.id) return true;
                    return false;
                })
                .singleOrError();
        };

    public Completable saveApproach(int id, double weight, int replay, String note) {
        return Completable
                .fromRunnable(() -> approaches.add(new Approach(id, weight, replay, note)));

    }

    public Observable<List<Approach>> observeApproaches() {
        return null;
    }
}