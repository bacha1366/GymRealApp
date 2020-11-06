package ru.bacha.gym;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Exercise.class, parentColumns = "id", childColumns = "idExercise"),
        @ForeignKey(entity = Workout.class, parentColumns = "id", childColumns = "idWorkout")
})

public class MySet {
    @PrimaryKey (autoGenerate = true)
    public int id;
    @ColumnInfo (index = true)
    public int idExercise;
    @ColumnInfo (index = true)
    public int idWorkout;
    public String note;
}
