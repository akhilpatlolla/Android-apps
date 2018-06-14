package edu.niu.cs.akhil.shippingcalculator;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Akhil on 1/26/17.
 */

public class ShipItem extends Activity {


    private Double weight,basecost,addedcost,totalcost;
    static final Double baseAmount = 3.0, addedAmount = 0.5,baseWeight = 16.0,extraOunce = 4.0;

    public ShipItem(){
        basecost = baseAmount;
        weight = addedcost = totalcost = 0.0;
    }

    public void setWeight(Double newWeight){
        weight = newWeight;
        computeCost();

    }
    public void computeCost() {
        addedcost = 0.0;
        basecost = baseAmount;
        if (weight <= 0)
            basecost = 0.0;
        else if (weight > baseWeight)
            addedcost = Math.ceil((weight - baseWeight) / extraOunce) * addedAmount;

        totalcost = basecost+ addedcost;
    }

    public Double getBasecost() {
        return basecost;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public Double getAddedcost() {
        return addedcost;
    }
}
