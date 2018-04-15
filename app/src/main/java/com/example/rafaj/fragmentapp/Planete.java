package com.example.rafaj.fragmentapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Planete implements Parcelable{
    private String surnom;
    private int nombre;

    public Planete(String surnom, int nombre) {
        this.surnom = surnom;
        this.nombre = nombre;
    }

    protected Planete(Parcel in) {
        surnom = in.readString();
        nombre = in.readInt();
    }

    public static final Creator<Planete> CREATOR = new Creator<Planete>() {
        @Override
        public Planete createFromParcel(Parcel in) {
            return new Planete(in);
        }

        @Override
        public Planete[] newArray(int size) {
            return new Planete[size];
        }
    };

    public String getSurnom() {
        return surnom;
    }

    public int getNombre() {
        return nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(surnom);
        parcel.writeInt(nombre);
    }
}
