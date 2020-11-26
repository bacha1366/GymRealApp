package ru.bacha.gym;

import java.util.Objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {
    @PrimaryKey
    public Long id;
    public String name;

    public Exercise(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }



}