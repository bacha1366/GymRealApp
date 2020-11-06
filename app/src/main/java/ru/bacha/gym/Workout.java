package ru.bacha.gym;

import java.util.Calendar;
import java.util.Date;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Workout {
    @PrimaryKey
    public int id;
    //public Calendar date;
}
