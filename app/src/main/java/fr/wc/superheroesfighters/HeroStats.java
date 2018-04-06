package fr.wc.superheroesfighters;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wilder on 06/04/18.
 */

public class HeroStats implements Parcelable {

    String name;
    int force;
    int intelligence;
    int durability;
    int combat;
    int speed;
    int power;


    public HeroStats(String name, int force, int intelligence, int durability, int combat, int speed, int power) {
        this.name = name;
        this.force = force;
        this.intelligence = intelligence;
        this.durability = durability;
        this.combat = combat;
        this.speed = speed;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getForce() {
        return force;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getDurability() {
        return durability;
    }

    public int getCombat() {
        return combat;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }

    protected HeroStats(Parcel in) {
        name = in.readString();
        force = in.readInt();
        intelligence = in.readInt();
        durability = in.readInt();
        combat = in.readInt();
        speed = in.readInt();
        power = in.readInt();
    }

    public static final Creator<HeroStats> CREATOR = new Creator<HeroStats>() {
        @Override
        public HeroStats createFromParcel(Parcel in) {
            return new HeroStats(in);
        }

        @Override
        public HeroStats[] newArray(int size) {
            return new HeroStats[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(force);
        parcel.writeInt(intelligence);
        parcel.writeInt(durability);
        parcel.writeInt(combat);
        parcel.writeInt(speed);
        parcel.writeInt(power);
    }
}
