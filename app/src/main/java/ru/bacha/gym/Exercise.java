package ru.bacha.gym;

public class Exercise {
    public final String name;
    public final int id;
    public double weight;
    public int replay;

    public Exercise(int id, String name, double weight, int replay) {
        this.name = name;
        this.id = id;
        this.weight = weight;
        this.replay = replay;
    }

    @Override
    public String toString() {
        return name;
    }
}