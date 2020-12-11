package ru.bacha.gym.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Exercise.class, parentColumns = "id", childColumns = "idExercise"),
        @ForeignKey(entity = Workout.class, parentColumns = "id", childColumns = "idWorkout")
})

public class MySet {
    @PrimaryKey (autoGenerate = true)
    public long id;
    @ColumnInfo (index = true)
    public Long idExercise;
    @ColumnInfo (index = true)
    public Long idWorkout;

    @Ignore
    public MySet(Long idExercise, Long idWorkout){
        this.idExercise = idExercise;
        this.idWorkout = idWorkout;
    }

    public MySet (long id, Long idExercise, Long idWorkout){
        this.id = id;
        this.idExercise = idExercise;
        this.idWorkout = idWorkout;
    }
}
