package fr.wc.superheroesfighters;

/**
 * Created by wilder on 05/04/18.
 */

public class SelectEnemyModel {
    private int imageEnemy;
    private String nameEnemy;

    public int getImageEnemy() {
        return imageEnemy;
    }

    public void setImageEnemy(int imageEnemy) {
        this.imageEnemy = imageEnemy;
    }

    public String getNameEnemy() {
        return nameEnemy;
    }

    public void setNameEnemy(String nameEnemy) {
        this.nameEnemy = nameEnemy;
    }

    public SelectEnemyModel(int imageEnemy, String nameEnemy) {
        this.imageEnemy = imageEnemy;
        this.nameEnemy = nameEnemy;

    }
}
