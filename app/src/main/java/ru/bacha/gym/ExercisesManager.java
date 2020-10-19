package ru.bacha.gym;

public class ExercisesManager {
    private Exercise[] myExercises = new Exercise[]{
            new Exercise(0, "Жим лежа", 90, 6),
            new Exercise(1, "Жим в Хаммере", 55, 8),
            new Exercise(2, "Кроссовер", 27, 12),
            new Exercise(3, "Баттерфляй", 51, 10),
            new Exercise(4, "Дельта на наклонной скамье", 6.5, 10),
            new Exercise(5, "Разводка сидя", 6, 12),
            new Exercise(6, "Приседания", 60, 10),
            new Exercise(7, "Гак", 50, 10)
    };

    public Exercise[] getMyExercises() {
        return myExercises;
    }

    public  Exercise getExercisesForID(int id){
        int i;
        for (i = 0; i < myExercises.length; i++) {
            if (id==myExercises[i].id) break;
        }
        return myExercises[i];
    }
}
