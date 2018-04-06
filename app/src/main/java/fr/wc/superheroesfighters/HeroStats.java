package fr.wc.superheroesfighters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
    Bitmap image;


    public HeroStats(String name, int force, int intelligence, int durability, int combat, int speed, int power, Bitmap image ) {
        this.name = name;
        this.force = force;
        this.intelligence = intelligence;
        this.durability = durability;
        this.combat = combat;
        this.speed = speed;
        this.power = power;
        this.image = image;
    }

    protected HeroStats(Parcel in) {
        name = in.readString();
        force = in.readInt();
        intelligence = in.readInt();
        durability = in.readInt();
        combat = in.readInt();
        speed = in.readInt();
        power = in.readInt();
        image = in.readParcelable(Bitmap.class.getClassLoader());
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

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(force);
        dest.writeInt(intelligence);
        dest.writeInt(durability);
        dest.writeInt(combat);
        dest.writeInt(speed);
        dest.writeInt(power);
        dest.writeParcelable(image, flags);
    }
}
