package ru.bacha.gym;

public class ExeClass {
    public String name;
    public double weight;
    public byte replay;

    @Override
    public String toString(){
        return name;
    }

    public void getName (String name){
        this.name = name;
    }
}