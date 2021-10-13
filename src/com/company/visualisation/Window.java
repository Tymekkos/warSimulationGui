package com.company.visualisation;

import com.company.engine.WorldEngine;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.*;

import static com.company.stats.ApplicationProperties.BOUND;

public class Window {

    public BorderPane mainLayout;
    private Grid grid;
    private Button startButton, daysButton, timeButton;
    private final Font buttonFont = Font.font("Verdana", FontWeight.BOLD,16);
    private final Font startFont = Font.font("Georgia", FontWeight.BOLD,22);

    public Window(){
        this.mainLayout = new BorderPane();

        mainLayout.setStyle("-fx-background-position: center");
        mainLayout.setStyle("-fx-background-color: lightskyblue");
        mainLayout.setPrefSize(600,700);

        setGridLayout();
        setButtons();
        setTopPanel();
        setBottomPanel();
    }
    private void setGridLayout(){
        grid = new Grid(BOUND);
        mainLayout.setCenter(grid.getGridPane());
    }

    private void setTopPanel(){
        HBox topPanel = new HBox();
        topPanel.setSpacing(20);
        topPanel.setStyle("-fx-background-color: lightseagreen");
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setMinHeight(60);
        topPanel.getChildren().addAll(startButton);
        mainLayout.setTop(topPanel);
    }

    private void setButtons(){
        //start
        this.startButton = new Button("Start");
        startButton.setStyle("-fx-background-color: #D8F8F6;"
                + "-fx-border-width: 3;"
                + "-fx-border-color: black;"
                + "-fx-border-radius: 7;"
                + "-fx-background-radius: 10");
        startButton.setMinSize(70,45);
        startButton.setFont(startFont);
        startButton.setOnAction(e -> {
            new WorldEngine(grid);
        });

        //days
        this.daysButton = new Button("Days");
        daysButton.setStyle("-fx-background-color: #F8D8D9;"
                + "-fx-border-width: 3;"
                + "-fx-border-color: black;"
                + "-fx-border-radius: 7;"
                + "-fx-background-radius: 10");
        daysButton.setMinSize(60,40);
        daysButton.setFont(buttonFont);
        daysButton.setOnAction(e -> {
            System.out.println("dziala");
        });

        this.timeButton = new Button("Time");
        timeButton.setStyle("-fx-background-color: #F8D8D9;"
                + "-fx-border-width: 3;"
                + "-fx-border-color: black;"
                + "-fx-border-radius: 7;"
                + "-fx-background-radius: 10");
        timeButton.setMinSize(60,40);
        timeButton.setFont(buttonFont);
        timeButton.setOnAction(e -> {
            System.out.println("dziala");
        });
    }

    private void setBottomPanel(){
        HBox bottomPanel = new HBox();
        bottomPanel.setSpacing(50);
        bottomPanel.setStyle("-fx-background-color: #9370DB");
        bottomPanel.setAlignment(Pos.CENTER);
        bottomPanel.getChildren().addAll(daysButton, timeButton);
        bottomPanel.setMinHeight(75);
        mainLayout.setBottom(bottomPanel);
    }
}
