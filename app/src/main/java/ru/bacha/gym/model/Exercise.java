package ru.bacha.gym.model;

import java.util.Objects;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {
    @PrimaryKey (autoGenerate = true)
    public long id;
    public String name;

    public Exercise(Long id, String name) {
        this.name = name;
        this.id = id;
    }
    @Ignore
    public Exercise(String name) {
        this.name = name;
    }
    /*@Override
    public String toString() {
        String string = name + "  " + id;
        return string;
    }*/



}