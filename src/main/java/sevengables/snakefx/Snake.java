/*
 * Copyright (c) 2021 Woodsville Interactive.
 *
 * Snake.java
 * Created on Nov 4, 2021 1:27:29 PM
 */
package sevengables.snakefx;

import javafx.scene.paint.Color;

/**
 *
 * @author Kyle Goulart
 */
public class Snake {

//    ArrayList<String> body;
    int yHeadLoc;
    int xHeadLoc;
    Color snakeColor;

    public Snake() {
//        body = new ArrayList<>();
        yHeadLoc = -1;
        xHeadLoc = -1;
        snakeColor = Color.RED;
    }

    public int getYHeadLoc() {

        return yHeadLoc;
    }
    
    public void setYHeadLoc(int y) {
        
        yHeadLoc = y;
    }

    public int getXHeadLoc() {

        return xHeadLoc;
    }
    
    public void setXHeadLoc(int x) {
        
        xHeadLoc = x;
    }
    
    public Color getSnakeColor() {
        
        return snakeColor;
    }

}
