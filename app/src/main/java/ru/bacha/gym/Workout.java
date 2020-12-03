package ru.bacha.gym;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

@Entity
public class Workout {
    @PrimaryKey
    public Long id;
    public String mydate;

    public Workout(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        mydate = dateFormat.format(new Date());
    }

    public Workout(Long id){
        this.id = id;
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        mydate = dateFormat.format(new Date());
    }

}
