package ru.bacha.gym.rx;

import java.util.Random;
import java.util.function.Consumer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxEducation {

    //этот метод должен вернуть Observable, который запаблишит число от 0 до 10
    Observable<Integer> getNumbersObservable() {
        return Observable.range(0,11);
        //throw new IllegalStateException("Not implemented yet");
    }

    //этот метод должен вернуть Observable, который опубликует числа от 0 до 10,
    // только в виде строк "0", "1" и т.д.
    // реализация должна использовать метод getNumbersObservable
    Observable<String> getNumberStringsObservable() {
        return getNumbersObservable().map(String::valueOf);
        //throw new IllegalStateException("Not implemented yet");
    }

    //этот метод должен вернуть Observable, который опубликует только ЧЕТНЫЕ числа от 0 до 10,
    // реализация должна использовать метод getNumbersObservable
    Observable<Integer> getEvenNumbersObservable() {
        return getNumbersObservable().filter(i -> i % 2 == 0);
        //throw new IllegalStateException("Not implemented yet");
    }

    //этот метод должен подписаться на переданный observable и все данные из него передать в функцию nextFunction,
    //а если случится exception = передать его в errorFunction
    void publishAllEvents(
            Observable<Integer> observable,
            Consumer<Integer> nextFunction,
            Consumer<Throwable> errorFunction
    ) {
        observable.subscribe(integer -> nextFunction.accept(integer),throwable ->
                errorFunction.accept(throwable));
        //throw new IllegalStateException("Not implemented yet");
    }


}
