package com.company.engine;

import com.company.consoleVisualisation.Visualisator;
import com.company.map.WorldMap;
import com.company.stats.ApplicationProperties;

import static com.company.stats.ApplicationProperties.charactersNumber;

public class WorldEngine {
    WorldMap worldMap;

    public WorldEngine(){
        worldMap = new WorldMap();
        worldMap.putCharactersOnMap(charactersNumber);

        for(int i = 0; i<ApplicationProperties.daysNumber; i++){
            worldMap.day();
            Visualisator.printWorld(worldMap);
        }

    }
}
