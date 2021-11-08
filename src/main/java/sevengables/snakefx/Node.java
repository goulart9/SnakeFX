/*
 * Copyright (c) 2021 Woodsville Interactive.
 *
 * Node.java
 * Created on Nov 8, 2021 11:57:08 AM
 */
package sevengables.snakefx;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Kyle Goulart
 */
public class Node extends Pane {
    
    public Node(Color c, double x, double y, double width, double height) {
        
        Rectangle r = new Rectangle(width, height);
        r.setStroke(Color.BLACK);
        r.setFill(c);
        
        setTranslateX(x);
        setTranslateY(y);
        
        getChildren().add(r);
    }

}
