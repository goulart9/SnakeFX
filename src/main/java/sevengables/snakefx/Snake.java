/*
 * Copyright (c) 2021 Woodsville Interactive.
 *
 * Snake.java
 * Created on Nov 4, 2021 1:27:29 PM
 */
package sevengables.snakefx;

/**
 *
 * @author Kyle Goulart
 */
public class Snake {

    String head;
//    ArrayList<String> body;
    int yHeadLoc;
    int xHeadLoc;

    public Snake() {
        head = "H";
//        body = new ArrayList<>();
        yHeadLoc = -1;
        xHeadLoc = -1;
    }
    
    public String getHeadString() {
        
        return head;
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

}
