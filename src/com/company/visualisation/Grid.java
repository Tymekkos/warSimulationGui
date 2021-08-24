package com.company.visualisation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Grid {

    private final GridPane gridPane;
    private final int[][] map;
    private final int blockSize;

    public Grid(int size) {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        map = new int[size][size];

        this.blockSize = 500/size;

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                Label cellLabel = new Label();

                cellLabel.setStyle("-fx-background-color: mintcream;" + "-fx-border-color: black;");
                cellLabel.setMinSize(blockSize, blockSize);
                cellLabel.setMaxSize(blockSize, blockSize);
                GridPane.setConstraints(cellLabel, i, j);
                gridPane.getChildren().addAll(cellLabel);

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
