package ru.bacha.gym;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Exercise.class, parentColumns = "id", childColumns = "idExercise"),
        @ForeignKey(entity = Workout.class, parentColumns = "id", childColumns = "idWorkout"))
public class MySet {
    @PrimaryKey
    public int id;
    public int idExercise;
    public int idWorkout;
    public String note;
}
