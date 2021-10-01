package com.company.visualisation;

import com.company.engine.WorldEngine;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.awt.*;

import static com.company.stats.ApplicationProperties.bound;

public class Window {

    public BorderPane mainLayout;
    private Grid grid;
    private Button startButton;

    public Window(){
        this.mainLayout = new BorderPane();

        mainLayout.setStyle("-fx-background-position: center");
        mainLayout.setStyle("-fx-background-color: lightskyblue");
        mainLayout.setPrefSize(600,700);

        setGridLayout();
        setButtons();
        setTopPanel();
    }
    private void setGridLayout(){
        grid = new Grid(bound);
        mainLayout.setCenter(grid.getGridPane());
    }

    private void setTopPanel(){
        HBox topPanel = new HBox();
        topPanel.setSpacing(20);
        topPanel.setStyle("-fx-background-color: lightseagreen");
        topPanel.setAlignment(Pos.CENTER);
        topPanel.getChildren().addAll(startButton);
        mainLayout.setTop(topPanel);
    }

    private void setButtons(){
        this.startButton = new Button("start");
        startButton.setStyle("-fx-background-color: lightgrey;"
                + "-fx-border-width: 2;"
                + "-fx-border-color: black;"
                + "-fx-border-radius: 7;"
                + "-fx-background-radius: 10");
        startButton.setOnAction(e -> {
            new WorldEngine(grid);
        });
    }
}
