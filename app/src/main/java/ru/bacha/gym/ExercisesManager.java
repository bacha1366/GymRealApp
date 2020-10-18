package ru.bacha.gym;

public class ExercisesManager {
    private ExeClass[] myExercises = new ExeClass[]{
            new ExeClass("Жим лежа", 90, 6),
            new ExeClass("Жим в Хаммере", 55, 8),
            new ExeClass("Кроссовер", 27, 12),
            new ExeClass("Баттерфляй", 51, 10),
            new ExeClass("Дельта на наклонной скамье", 6.5, 10),
            new ExeClass("Разводка сидя", 6, 12),
            new ExeClass("Приседания", 60, 10),
            new ExeClass("Гак", 50, 10)
    };

    public ExeClass[] getMyExercises() {
        return myExercises;
    }
}
