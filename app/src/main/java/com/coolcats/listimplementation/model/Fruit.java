package com.coolcats.listimplementation.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Fruit implements Parcelable {
    private String name;
    private String image;
    private int energy;


    protected Fruit(Parcel in) {
        name = in.readString();
        image = in.readString();
        energy = in.readInt();
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    @Override
    public String toString() {
        return name + " with "+ energy+ " kj of energy.";
    }

    public Fruit(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public Fruit(String name, String image, int energy) {
        this.name = name;
        this.image = image;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeInt(energy);
    }
}
