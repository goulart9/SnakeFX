/*
 * Copyright (c) 2021 Woodsville Interactive.
 *
 * Food.java
 * Created on Nov 4, 2021 1:20:40 PM
 */
package sevengables.snakefx;

import javafx.scene.paint.Color;


/**
 *
 * @author Kyle Goulart
 */
public class Food {

    int yFoodLoc;
    int xFoodLoc;
    Color foodColor;

    public Food() {
        yFoodLoc = -1;
        xFoodLoc = -1;
        foodColor = Color.GREEN;
    }

    public int getYFoodLoc() {

        return yFoodLoc;
    }

    public void setYFoodLoc(int y) {

        yFoodLoc = y;
    }

    public int getXFoodLoc() {

        return xFoodLoc;
    }

    public void setXFoodLoc(int x) {

        xFoodLoc = x;
    }

    public Color getFoodColor() {

        return foodColor;
    }

}
