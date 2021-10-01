package com.company.map;

import com.company.factory.CharacterFactory;
import com.company.factory.RandomVector2dFactory;
import com.company.model.ICharacter;
import com.company.util.Vector2d;
import com.company.visualisation.Grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.map.WorldMapUtils.pvpForList;
import static com.company.stats.ApplicationProperties.*;

public class WorldMap {
    private Grid grid;
    private final Map<Vector2d, List<ICharacter>> map = new HashMap<>();

    public WorldMap(Grid grid){
        this.grid = grid;
        for(int i=0; i<bound; i++) {
            for(int j=0; j<bound; j++) {
                map.put(new Vector2d(j, i), new ArrayList<>());
                }
            }
        }

    public Map<Vector2d, List<ICharacter>> getMap() {
        return map;
    }

    public void putCharactersOnMap(int charactersNumber){
        for(int i=0; i<charactersNumber; i++){
            map.get(RandomVector2dFactory.getRandomVector2d(bound)).add(CharacterFactory.getRandomCharacter());
        }
        repaint();
    }


    public void printAllCharacters(){
        map.forEach((vector2d, iCharacters) -> iCharacters.forEach(iCharacter -> System.out.println(iCharacter.toString() + vector2d.toString())));
    }

    public void day(){

        Map<Vector2d, List<ICharacter>> mockMap = new HashMap<>();

        map.forEach(((vector2d, iCharacters) -> {
            List<ICharacter> ICharacterList = new ArrayList<>(iCharacters);
            mockMap.put(vector2d, ICharacterList);
        }));

        mockMap.forEach(((vector2d, iCharacters) -> iCharacters.forEach(iCharacter -> iCharacter.move(map, vector2d))));

        //pvp
        Map<Vector2d, List<ICharacter>> mockMap2 = new HashMap<>();

        map.forEach(((vector2d, iCharacters) -> {
            List<ICharacter> ICharacterList = new ArrayList<>(iCharacters);
            mockMap2.put(vector2d, ICharacterList);
        }));

        mockMap2.forEach(((vector2d, iCharacters) -> {
            pvpForList(iCharacters);
            for(int i=0; i<iCharacters.size(); i++){
                if(i % 2 == 1){
                    var child = CharacterFactory.getParticularCharacter(iCharacters.get(i));
                    var newField = RandomVector2dFactory.getFieldAroundTheVector2d(vector2d, bound);
                    if(map.get(newField).isEmpty()){
                        map.get(newField).add(child);
                    }
                }
                var character = map.get(vector2d).get(i);
                character.setAge(character.getAge()+1);
            }
        }));

        //removing elders
        Map<Vector2d, List<ICharacter>> mockMap3 = new HashMap<>();

        map.forEach(((vector2d, iCharacters) -> {
            List<ICharacter> ICharacterList = new ArrayList<>(iCharacters);
            mockMap3.put(vector2d, ICharacterList);
        }));
        mockMap3.forEach(((vector2d, iCharacters) -> {
            pvpForList(iCharacters);
            for(int i=iCharacters.size()-1; i>=1; i--){
                var character = map.get(vector2d).get(i);
                if(character.getAge()>=maxCharactersAge){
                    map.get(vector2d).remove(character);
                }
            }
        }));
    }

    private void repaint() {

    }

}
