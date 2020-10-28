package ru.bacha.gym.rx;

import org.junit.Test;

import java.util.function.Consumer;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class RxEducationTest {

    private RxEducation rxEducation = new RxEducation();

    @Test
    public void getNumbersObservable() {
        TestObserver<Integer> observer = new TestObserver<>();
        rxEducation.getNumbersObservable().subscribe(observer);
        observer.assertValues(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    public void getNumberStringsObservable() {
        TestObserver<String> observer = new TestObserver<>();
        rxEducation.getNumberStringsObservable().subscribe(observer);
        observer.assertValues("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }

    @Test
    public void getEvenNumbersObservable() {
        TestObserver<Integer> observer = new TestObserver<>();
        rxEducation.getEvenNumbersObservable().subscribe(observer);
        observer.assertValues(0, 2, 4, 6, 8, 10);
    }

    @Test
    public void publishIntegers() {
        BehaviorSubject<Integer> subject = BehaviorSubject.create();
        TestObserver<Integer> observer = new TestObserver<>();
        Consumer<Integer> consumer = subject::onNext;
        Consumer<Throwable> throwableConsumer = subject::onError;
        subject.subscribe(observer);
        rxEducation.publishAllEvents(Observable.just(3, 4, 5), consumer, throwableConsumer);
        observer.assertValues(3, 4, 5);
    }

    @Test
    public void publishError() {
        BehaviorSubject<Integer> subject = BehaviorSubject.create();
        TestObserver<Integer> observer = new TestObserver<>();
        Consumer<Integer> consumer = subject::onNext;
        Consumer<Throwable> throwableConsumer = subject::onError;
        subject.subscribe(observer);
        Throwable error = new IllegalStateException();
        rxEducation.publishAllEvents(Observable.error(error), consumer, throwableConsumer);
        observer.assertError(error);
    }

    @Test
    public void publishDataAndError() {
        BehaviorSubject<Integer> subject = BehaviorSubject.create();
        TestObserver<Integer> observer = new TestObserver<>();
        Consumer<Integer> consumer = subject::onNext;
        Consumer<Throwable> throwableConsumer = subject::onError;
        subject.subscribe(observer);
        Throwable error = new IllegalStateException();
        rxEducation.publishAllEvents(Observable.create(emitter -> {
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onError(error);
        }), consumer, throwableConsumer);
        observer.assertError(error);
        observer.assertValues(3, 4, 5);
    }
}