package ru.bacha.gym;

import java.util.Objects;

public class Exercise {
    public final String name;
    public final int id;

    public Exercise(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }




    //equals && hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return id == exercise.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}