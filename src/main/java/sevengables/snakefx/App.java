/*
 * Copyright (c) 2021 Woodsville Interactive.
 *
 * App.java
 * Created on Nov 5, 2021 12:27:13 PM
 */
package sevengables.snakefx;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Kyle Goulart
 */
public class App extends Application {

    Snake snake = new Snake();
    Food food = new Food();

    final int GRID_SIZE = 10;
    final int DELAY_MILLISECONDS = 100;
    final private double sceneWidth = 640;
    final private double sceneHeight = 480;
    double nodeWidth = sceneWidth / GRID_SIZE;
    double nodeHeight = sceneHeight / GRID_SIZE;
    Group root = new Group();
    Node[][] gridArray;
    Color emptyColor = Color.rgb(0, 0, 0, 0.0);
//    String[][] gridArray;
//    String empty = "a";
    Random r = new Random();
    int score = 1;

    @Override
    public void start(Stage stage) {

        buildGrid();
        placeSnakeHead();
        spawnFood();

        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        stage.setScene(scene);
        stage.show();

//        createGrid(GRID_SIZE, GRID_SIZE);
//        placeSnakeHead();
//        spawnFood();
//
//        TextArea ta = new TextArea();
//        ta.setOnKeyPressed((KeyEvent key) -> {
//            updateSnakeLoc(key);
//            updateFoodLoc();
//        });
//        ta.setEditable(false);
//
//        Scene scene = new Scene(new StackPane(new Label(), ta), sceneWidth, sceneHeight);
//        stage.setScene(scene);
//        stage.show();
//
//        ta.requestFocus();
//
//        final Timeline tl = new Timeline(
//                new KeyFrame(
//                        Duration.millis(DELAY_MILLISECONDS),
//                        event -> {
//                            ta.setText(build());
//                        }
//                )
//        );
//        tl.setCycleCount(Animation.INDEFINITE);
//        tl.play();
    }

    private int getRandomLoc(int upperBound) {

        return r.nextInt(upperBound);
    }

    private Node getNode(Color c, double x, double y) {

        return new Node(c, x * nodeWidth, y * nodeHeight, nodeWidth, nodeHeight);
    }

    private void buildGrid() {

        gridArray = new Node[GRID_SIZE][GRID_SIZE];

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Node node = getNode(emptyColor, i, j);
                
                root.getChildren().add(node);
                
                gridArray[i][j] = node;
            }
        }
    }

    private void placeSnakeHead() {

        if (snake.getYHeadLoc() == -1 && snake.getXHeadLoc() == -1) {
            snake.setYHeadLoc(getRandomLoc(GRID_SIZE));
            snake.setXHeadLoc(getRandomLoc(GRID_SIZE));
        }

        Node snakeNode = getNode(snake.getSnakeColor(), snake.getYHeadLoc(), snake.getXHeadLoc());

        root.getChildren().add(snakeNode);

        gridArray[snake.getYHeadLoc()][snake.getXHeadLoc()] = snakeNode;
    }

    private void spawnFood() {

        int randY = getRandomLoc(GRID_SIZE);
        int randX = getRandomLoc(GRID_SIZE);

        if (randY == snake.getYHeadLoc() && randX == snake.getXHeadLoc()) {
            randY = getRandomLoc(GRID_SIZE);
            randX = getRandomLoc(GRID_SIZE);
        }

        food.setYFoodLoc(randY);
        food.setXFoodLoc(randX);

        Node foodNode = getNode(food.getFoodColor(), food.getYFoodLoc(), food.getXFoodLoc());

        root.getChildren().add(foodNode);

        gridArray[food.getYFoodLoc()][food.getXFoodLoc()] = foodNode;
    }

    private void updateSnakeLoc(KeyEvent event) {

        gridArray[snake.getYHeadLoc()][snake.getXHeadLoc()] = getNode(emptyColor, snake.getYHeadLoc(), snake.getXHeadLoc());

        switch (event.getCode()) {

            case UP:
                snake.setYHeadLoc(snake.getYHeadLoc() - 1);

                if (snake.getYHeadLoc() < 0) {
                    // gameover
                }
                break;

            case DOWN:
                snake.setYHeadLoc(snake.getYHeadLoc() + 1);

                if (snake.getYHeadLoc() > GRID_SIZE - 1) {
                    // gameover
                }
                break;

            case LEFT:
                snake.setXHeadLoc(snake.getXHeadLoc() - 1);

                if (snake.getXHeadLoc() < 0) {
                    // gameover
                }
                break;

            case RIGHT:
                snake.setXHeadLoc(snake.getXHeadLoc() + 1);

                if (snake.getXHeadLoc() > GRID_SIZE - 1) {
                    // gameover
                }
                break;
        }

        placeSnakeHead();
    }

//    private void createGrid(int yDim, int xDim) {
//
//        gridArray = new String[xDim][yDim];
//
//        for (int x = 0; x < xDim; x++) {
//            for (int y = 0; y < yDim; y++) {
//                gridArray[x][y] = empty;
//            }
//        }
//    }
//
//    private void placeSnakeHead() {
//
//        if (snake.getYHeadLoc() == -1 && snake.getXHeadLoc() == -1) {
//            snake.setYHeadLoc(getRandomLoc(GRID_SIZE));
//            snake.setXHeadLoc(getRandomLoc(GRID_SIZE));
//        }
//
//        gridArray[snake.getYHeadLoc()][snake.getXHeadLoc()] = snake.getHeadString();
//    }
//
//    private String build() {
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("Score: ").append(score).append("\n");
//
//        for (int y = 0; y < GRID_SIZE; y++) {
//            for (int x = 0; x < GRID_SIZE; x++) {
//                sb.append(gridArray[y][x]);
//            }
//            sb.append("\n");
//        }
//
//        return sb.toString();
//    }
//
//    private void updateSnakeLoc(KeyEvent event) {
//
//        gridArray[snake.getYHeadLoc()][snake.getXHeadLoc()] = empty;
//
//        switch (event.getCode()) {
//
//            case UP:
//                snake.setYHeadLoc(snake.getYHeadLoc() - 1);
//                
//                if (snake.getYHeadLoc() < 0) {
//                    // gameover
//                }
//                break;
//
//            case DOWN:
//                snake.setYHeadLoc(snake.getYHeadLoc() + 1);
//                
//                if (snake.getYHeadLoc() > GRID_SIZE - 1) {
//                    // gameover
//                }
//                break;
//
//            case LEFT:
//                snake.setXHeadLoc(snake.getXHeadLoc() - 1);
//                
//                if (snake.getXHeadLoc() < 0) {
//                    // gameover
//                }
//                break;
//
//            case RIGHT:
//                snake.setXHeadLoc(snake.getXHeadLoc() + 1);
//                
//                if (snake.getXHeadLoc() > GRID_SIZE - 1) {
//                    // gameover
//                }
//                break;
//        }
//
//        placeSnakeHead();
//    }
//
//    private void spawnFood() {
//
//        int randY = getRandomLoc(GRID_SIZE);
//        int randX = getRandomLoc(GRID_SIZE);
//
//        if (randY == snake.getYHeadLoc() && randX == snake.getXHeadLoc()) {
//            randY = getRandomLoc(GRID_SIZE);
//            randX = getRandomLoc(GRID_SIZE);
//        }
//
//        food.setYFoodLoc(randY);
//        food.setXFoodLoc(randX);
//
//        gridArray[food.getYFoodLoc()][food.getXFoodLoc()] = food.getFoodString();
//    }
//
//    private void updateFoodLoc() {
//
//        boolean eaten = snakeEatsFood();
//
//        if (eaten == true) {
//            gridArray[food.getYFoodLoc()][food.getXFoodLoc()] = snake.getHeadString();
//            spawnFood();
//        }
//    }
//
//    private boolean snakeEatsFood() {
//
//        boolean eaten = false;
//
//        int snakeY = snake.getYHeadLoc();
//        int snakeX = snake.getXHeadLoc();
//        int foodY = food.getYFoodLoc();
//        int foodX = food.getXFoodLoc();
//
//        if (snakeY == foodY && snakeX == foodX) {
//            eaten = true;
//            score += 5;
//        }
//
//        return eaten;
//    }
//
    public static void main(String[] args) {
        launch(args);
    }

}
