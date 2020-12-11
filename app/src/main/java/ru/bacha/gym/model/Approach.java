package ru.bacha.gym.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Approach {
    @PrimaryKey
    public long id;
    public long idSet;
    public double weight;
    public int replay;
    public String note;


    @Ignore
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
