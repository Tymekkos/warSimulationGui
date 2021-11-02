package com.company.visualisation;

import com.company.engine.WorldEngine;
import com.company.exceptions.RangeValidationException;
import com.company.stats.ApplicationProperties;
import com.company.validators.TimeInputValidator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.text.Normalizer;

import static com.company.stats.ApplicationProperties.BOUND;
import static com.company.stats.ApplicationProperties.getDaysNumber;

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
            Button confirm = new Button("confirm");
            confirm.setMinSize(60,40);
            confirm.setFont(buttonFont);


            Stage daysForm = new Stage();
            daysForm.initModality(Modality.APPLICATION_MODAL);
            daysForm.setTitle("days choose");
            daysForm.setMinWidth(200);
            daysForm.setMinHeight(150);

            VBox vBox_2 = new VBox();
            vBox_2.setSpacing(20);
            vBox_2.setPadding(new Insets(20));
            vBox_2.setAlignment(Pos.TOP_CENTER);

            TextField daysNumber = new TextField();
            vBox_2.getChildren().addAll(daysNumber, confirm);

            confirm.setOnAction(event->{
                Integer days;
                    try {
                    days = Integer.parseInt(String.valueOf(daysNumber.getCharacters()));
                    ApplicationProperties.setDaysNumber(days);
                    daysForm.close();
                }catch(NumberFormatException ex){
                    System.out.println("nie udalo sie ");
                }
            });

            daysForm.setScene(new Scene(vBox_2));
            daysForm.show();
            daysForm.centerOnScreen();


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
            Button confirm = new Button("confirm");
            confirm.setMinSize(60,40);
            confirm.setFont(buttonFont);


            Stage timeForm = new Stage();
            timeForm.initModality(Modality.APPLICATION_MODAL);
            timeForm.setTitle("time choose");
            timeForm.setMinWidth(200);
            timeForm.setMinHeight(150);

            VBox vBox_2 = new VBox();
            vBox_2.setSpacing(20);
            vBox_2.setPadding(new Insets(20));
            vBox_2.setAlignment(Pos.TOP_CENTER);

            TextField time = new TextField();
            vBox_2.getChildren().addAll(time, confirm);

            confirm.setOnAction(event->{
                int timeInput;
                try {
                    timeInput = Integer.parseInt(String.valueOf(time.getCharacters()));
                    TimeInputValidator.test(timeInput);
                    ApplicationProperties.setTime(timeInput);
                    timeForm.close();
                }catch(NumberFormatException | RangeValidationException ex){
                    showAlertBox(ex.getMessage());
                }
            });

            timeForm.setScene(new Scene(vBox_2));
            timeForm.show();
            timeForm.centerOnScreen();
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

    private void showAlertBox(String message){
        Stage alert = new Stage();
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("alert");
        alert.setMinWidth(200);
        alert.setMinHeight(150);
        Label label = new Label(message);
        alert.setScene(new Scene(label));
        alert.show();
    }
}
