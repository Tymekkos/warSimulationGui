package com.company.visualisation;

import javafx.scene.layout.BorderPane;
import static com.company.stats.ApplicationProperties.bound;

public class Window {

    public BorderPane mainLayout;
    private Grid grid;

    public Window(){
        this.mainLayout = new BorderPane();

        mainLayout.setStyle("-fx-background-position: center");
        mainLayout.setStyle("-fx-background-color: lightskyblue");
        mainLayout.setPrefSize(600,700);

        setGridLayout();
    }
    private void setGridLayout(){
        grid = new Grid(bound);
        mainLayout.setCenter(grid.getGridPane());
    }
}
