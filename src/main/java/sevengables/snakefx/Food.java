/*
 * Copyright (c) 2021 Woodsville Interactive.
 *
 * Food.java
 * Created on Nov 4, 2021 1:20:40 PM
 */
package sevengables.snakefx;

/**
 *
 * @author Kyle Goulart
 */
public class Food {

    String foodObj;
    int yFoodLoc;
    int xFoodLoc;

    public Food() {
        foodObj = "F";
        yFoodLoc = -1;
        xFoodLoc = -1;
    }

    public String getFoodString() {

        return foodObj;
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

}
