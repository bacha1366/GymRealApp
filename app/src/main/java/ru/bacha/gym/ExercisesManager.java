package ru.bacha.gym;

public class ExercisesManager {
    private ExeClass[] myExercises = new ExeClass[]{
            new ExeClass("Exercise 1"),
            new ExeClass("Exercise 2"),
            new ExeClass("Exercise 3"),
            new ExeClass("Exercise 4"),
            new ExeClass("Exercise 5"),
            new ExeClass("Exercise 6"),
            new ExeClass("Exercise 7"),
            new ExeClass("Exercise 8")
    };

    public ExeClass[] getMyExercises() {
        return myExercises;
    }
}
