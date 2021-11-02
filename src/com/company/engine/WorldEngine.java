package com.company.engine;

import com.company.map.WorldMap;
import com.company.visualisation.Grid;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

import static com.company.stats.ApplicationProperties.*;

public class WorldEngine {
    WorldMap worldMap;
    Grid grid;
    Timer timer;
    private int days = 0;

    public WorldEngine(Grid grid){
        timer = new Timer();
        worldMap = new WorldMap(grid);
        worldMap.putCharactersOnMap(CHARACTERS_NUMBER);
        this.grid = grid;

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() ->{
                    days++;
                    worldMap.day();
                    if(days > DAYS_NUMBER){
                        timer.cancel();
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, TIME);
    }
}
