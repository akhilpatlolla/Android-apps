package edu.niu.cs.akhil.widget;

/**
 * Created by akhil on 1/31/17.
 */

public class Burger {
    static final int BEEF = 2000,
                     TURKEY = 1800,
                     VEGGIE = 2354,
                     CHEDDAR = 1353,
                     MOZZ =4545,
                     BACON =3467;
    private int pattyCalories, cheeseCalories, baconCalories, sauceCalories;

    public Burger(){
        pattyCalories = TURKEY;
        cheeseCalories = CHEDDAR;
        baconCalories = sauceCalories = 0;

    }

    public void setPattyCalories(int pattyCalories) {
        this.pattyCalories = pattyCalories;
    }

    public void setCheeseCalories(int cheeseCalories) {
        this.cheeseCalories = cheeseCalories;
    }

    public void setBaconCalories(boolean hasBacon) {
        if (hasBacon)
            this.baconCalories = BACON;
        else
            this.baconCalories = 0;
    }

    public void setSauceCalories(int sauceCalories) {
        this.sauceCalories = sauceCalories;
    }

    int getTotalCalories(){
        return pattyCalories+cheeseCalories+baconCalories+sauceCalories;
    }
}

