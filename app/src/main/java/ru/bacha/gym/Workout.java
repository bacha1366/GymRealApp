package ru.bacha.gym;

import java.util.Calendar;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Workout {
    @PrimaryKey
    public int id;
    public Calendar date;
    public String location;
}
