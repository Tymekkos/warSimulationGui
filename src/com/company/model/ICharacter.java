package com.company.model;

import com.company.util.Vector2d;
import com.company.util.WorldDirections;

import java.util.List;
import java.util.Map;

public interface ICharacter {
    public int attack(int opponentArmor);

    default void move(Map<Vector2d, List<ICharacter>> map, Vector2d vector2d){

        map.get(vector2d).remove(this);

        switch (WorldDirections.getRandomDirection()){
            case NORTH:
                map.get(vector2d.getNewVector2d(WorldDirections.NORTH)).add(this);
                break;
            case SOUTH:
                map.get(vector2d.getNewVector2d(WorldDirections.SOUTH)).add(this);
                break;
            case WEST:
                map.get(vector2d.getNewVector2d(WorldDirections.WEST)).add(this);
                break;
            case EAST:
                map.get(vector2d.getNewVector2d(WorldDirections.EAST)).add(this);
                break;
        }
    }
    default boolean isTheSameProfession(ICharacter opponent){
        return this.getClass().equals(opponent.getClass());
    }
    public int getHP();
    public int getAttack();
    public void setAttack(int attack);
    public void setHP(int hp);
    public int getArmor();
    public void restartHP();
    public int getAge();
    public void setAge(int age);
}
