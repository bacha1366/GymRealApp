package ru.bacha.gym;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Approach {
    @PrimaryKey
    public Long id;
    public Long idSet;
    public double weight;
    public int replay;
    public String note;


    public Approach(Long idSet, double weight, int replay, String note) {
        this.idSet = idSet;
        this.weight = weight;
        this.replay = replay;
        this.note = note;
    }


    public Approach(Long id, Long idSet, double weight, int replay, String note) {
        this.id = id;
        this.idSet = idSet;
        this.weight = weight;
        this.replay = replay;
        this.note = note;
    }
}
