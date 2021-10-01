package com.company.visualisation;

import com.company.stats.ApplicationProperties;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import static com.company.stats.ApplicationProperties.bound;

import javax.swing.*;

public class Grid {

    private final GridPane gridPane;
    private final int[][] map;
    private final int blockSize;

    public Grid(int bound) {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        map = new int[ApplicationProperties.bound][ApplicationProperties.bound];

        this.blockSize = 500/ ApplicationProperties.bound;

        emptyPane();
    }

    public void changeCellColor(int x, int y, String color) {
        Label cellLabel = new Label();

        cellLabel.setStyle("-fx-background-color: " + color + ";" + "-fx-border-color: black;");
        cellLabel.setMinSize(blockSize, blockSize);
        cellLabel.setMaxSize(blockSize, blockSize);
        GridPane.setConstraints(cellLabel, x, y);
        gridPane.getChildren().addAll(cellLabel);
    }

    public void emptyPane(){
        for(int i=0; i<bound; i++){
            for(int j=0; j<bound; j++){
                changeCellColor(i, j, "white");
            }
        }
    }
    public GridPane getGridPane() {
        return gridPane;
    }

    public int[][] getMap() {
        return map;
    }
}
