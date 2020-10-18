package ru.bacha.gym;

import android.os.Parcel;
import android.os.Parcelable;

public class ExeClass implements Parcelable {
    public String name;
    public double weight;
    public byte replay;

    public ExeClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }












    //это вспомогательные вещи для Parcelable, не обращайте на них внимания
    protected ExeClass(Parcel in) {
        name = in.readString();
        weight = in.readDouble();
        replay = in.readByte();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(weight);
        dest.writeByte(replay);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ExeClass> CREATOR = new Creator<ExeClass>() {
        @Override
        public ExeClass createFromParcel(Parcel in) {
            return new ExeClass(in);
        }

        @Override
        public ExeClass[] newArray(int size) {
            return new ExeClass[size];
        }
    };

}