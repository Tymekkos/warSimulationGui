package com.company.engine;

import com.company.consoleVisualisation.Visualisator;
import com.company.map.WorldMap;
import com.company.stats.ApplicationProperties;
import com.company.visualisation.Grid;

import static com.company.stats.ApplicationProperties.charactersNumber;

public class WorldEngine {
    WorldMap worldMap;
    Grid grid;

    public WorldEngine(Grid grid){
        worldMap = new WorldMap(grid);
        worldMap.putCharactersOnMap(charactersNumber);
        this.grid = grid;

        grid.getGridPane();

        for(int i = 0; i<ApplicationProperties.daysNumber; i++){
            worldMap.day();
            Visualisator.printWorld(worldMap);
        }
    }
}
