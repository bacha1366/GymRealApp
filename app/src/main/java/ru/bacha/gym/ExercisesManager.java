package ru.bacha.gym;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ExercisesManager {

    public List<Approach> approaches = new ArrayList<Approach>();

    private Exercise[] myExercises = new Exercise[]{
            new Exercise(0, "Жим лежа"),
            new Exercise(1, "Жим в Хаммере"),
            new Exercise(2, "Кроссовер"),
            new Exercise(3, "Баттерфляй"),
            new Exercise(4, "Дельта на наклонной скамье"),
            new Exercise(5, "Разводка сидя"),
            new Exercise(6, "Приседания"),
            new Exercise(7, "Гак")
    };


    public Single<List<Exercise>> getMyExercises() {
        return null;
    }


    //есть два способа ответа на неправильно введенный id. Первый - возвращать null вместо Exercise,
    // второй - выбрасывать ошибку. Мне больше нравится второй, потому что он сразу дает понять, что
    // мы что-то сделали не так.
    public Single<Exercise> getExerciseForID(int id) {
        //int i;
        for (int i = 0; i < myExercises.length; i++) {
            if (id == myExercises[i].id) return myExercises[i];
        }
        throw new IllegalArgumentException("Не могу найти упражнение с id" + id);
    }

    public Completable saveApproach(int id, double weight, int replay) {
        approaches.add(new Approach(id, weight, replay));
    }

    public Observable<List<Approach>> observeApproaches() {
        return null;
    }
}