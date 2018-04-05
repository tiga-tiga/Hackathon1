package fr.wc.superheroesfighters;

import java.util.Random;

/**
 * Created by wilder on 05/04/18.
 */

public class Fighters {
    private String fighter1;
    private String fighter2;
    private int life1;
    private int life2;
    private int durability1;
    private int durability2;
    private int power1;
    private int power2;
    private int strenght1;
    private int strenght2;
    private int speed1;
    private int speed2;
    private int combat1;
    private int combat2;
    private int intelligence1;
    private int intelligence2;

    public Fighters(String fighter1, String fighter2, int durability1, int durability2, int power1, int power2, int strenght1, int strenght2, int speed1, int speed2, int combat1, int combat2, int intelligence1, int intelligence2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.life1 = 10 + durability1 + power1;
        this.life2 = 10 + durability2 + power2;
    }

    public String getFighter1() {
        return fighter1;
    }

    public void setFighter1(String fighter1) {
        this.fighter1 = fighter1;
    }

    public String getFighter2() {
        return getFighter2();
    }

    public void setFighter2(String fighter2) {
        this.fighter2 = fighter2;
    }

    public int getLife1() {
        return life1;
    }

    public void setLife1(int durability1, int power1) {
        this.life1 = 10 + durability1 + power1;
    }

    public int getLife2() {
        return life2;
    }

    public void setLife2(int durability2, int power2) {
        this.life2 = 10 + durability2 + power2;
    }




    // Serie de coup
    public void takeHit1Physique(){
        // valeur aléatoire
        Random r1 = new Random();
        int degats = ((strenght1 + power1 + speed1) - (durability2 + speed2));
        if (degats < 0){
            degats = 0;
        }
        this.life2 = life2 - degats;
    }
    public void takeHit1Mental(){

        int degats = (intelligence1 + combat1 + speed1) - (intelligence2 +durability2);
        if(degats < 0){
            degats = 0;
        }
        this.life2 = life2 - degats;
    }
    public void takeHit1Special(){
        Random r1 = new Random();
        int degats = (strenght1 +intelligence1)*r1.nextInt(4) -(durability2 + power2);
        if(degats < 0){
            degats = 0;
        }
        this.life2 = life2 - degats;
    }

    public void takeHit2Physique(){
        int degats = ((strenght2 + power2 + speed2) - (durability1 + speed1));
        if (degats < 0){
            degats = 0;
        }
        this.life1 = life1 - degats;

    }
    public void takeHit2Mental(){

        int degats = (intelligence2 + combat2 + speed2) - (intelligence2 +durability2);
        if(degats < 0){
            degats = 0;
        }
        this.life1 = life1 - degats;
    }
    public void takeHit2Special(){
        Random r1 = new Random();
        int degats = (strenght2 +intelligence2)*r1.nextInt(4) -(durability1 + power1);
        if(degats < 0){
            degats = 0;
        }
        this.life1 = life1 - degats;
    }

    /*public boolean isKO1(){
        return this.life1 <= 0;//if life <= 0 return true
    }
    public boolean isKO2(){
        return this.life2 <= 0;//if life <= 0 return true
    }

    public void revive (){

        this.life1 = 100;
        this.life2 = 100;
    }*/
}
