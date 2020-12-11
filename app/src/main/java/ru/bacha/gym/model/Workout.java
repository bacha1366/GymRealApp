package ru.bacha.gym.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Workout {
    @PrimaryKey
    public Long id;

    @NonNull
    public String date;

    @Ignore
    public Workout(String date){
        this.date = date;
    }

    public Workout(Long id, String date){
        this.id = id;
        this.date = date;
    }




}
