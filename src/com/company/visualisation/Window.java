package com.company.visualisation;

import javafx.scene.layout.BorderPane;

public class Window {

    public BorderPane mainLayout;
    private Grid grid;
    private final int SIZE = 50;

    public Window(){
        this.mainLayout = new BorderPane();

        mainLayout.setStyle("-fx-background-position: center");
        mainLayout.setStyle("-fx-background-color: lightskyblue");
        mainLayout.setPrefSize(600,700);

        setGridLayout();
    }

    private void setGridLayout(){
        grid = new Grid(SIZE);
        mainLayout.setCenter(grid.getGridPane());
    }
}
