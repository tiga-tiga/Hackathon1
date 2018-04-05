package fr.wc.superheroesfighters;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wilder on 05/04/18.
 */

public class SelectEnemyModel implements Parcelable{

    private String imageEnemy;
    private String nameEnemy;
    private int intell;
    private int force;
    private int speed;
    private int dur;
    private int powr;
    private int cmbt;

    protected SelectEnemyModel(Parcel in) {
        imageEnemy = in.readString();
        nameEnemy = in.readString();
        intell = in.readInt();
        force = in.readInt();
        speed = in.readInt();
        dur = in.readInt();
        powr = in.readInt();
        cmbt = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageEnemy);
        dest.writeString(nameEnemy);
        dest.writeInt(intell);
        dest.writeInt(force);
        dest.writeInt(speed);
        dest.writeInt(dur);
        dest.writeInt(powr);
        dest.writeInt(cmbt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SelectEnemyModel> CREATOR = new Creator<SelectEnemyModel>() {
        @Override
        public SelectEnemyModel createFromParcel(Parcel in) {
            return new SelectEnemyModel(in);
        }

        @Override
        public SelectEnemyModel[] newArray(int size) {
            return new SelectEnemyModel[size];
        }
    };

    public String getImageEnemy() {
        return imageEnemy;
    }

    public void setImageEnemy(String imageEnemy) {
        this.imageEnemy = imageEnemy;
    }

    public String getNameEnemy() {
        return nameEnemy;
    }

    public void setNameEnemy(String nameEnemy) {
        this.nameEnemy = nameEnemy;
    }

    public int getIntell() {
        return intell;
    }

    public void setIntell(int intell) {
        this.intell = intell;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDur() {
        return dur;
    }

    public void setDur(int dur) {
        this.dur = dur;
    }

    public int getPowr() {
        return powr;
    }

    public void setPowr(int powr) {
        this.powr = powr;
    }

    public int getCmbt() {
        return cmbt;
    }

    public void setCmbt(int cmbt) {
        this.cmbt = cmbt;
    }

    public SelectEnemyModel(String imageEnemy, String nameEnemy, int intell, int force, int speed, int dur, int powr, int cmbt) {

        this.imageEnemy = imageEnemy;
        this.nameEnemy = nameEnemy;
        this.intell = intell;
        this.force = force;
        this.speed = speed;
        this.dur = dur;
        this.powr = powr;
        this.cmbt = cmbt;
    }



}
