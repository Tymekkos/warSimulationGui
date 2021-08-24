package com.company.util;

import java.util.Objects;

public class Vector2d {
    private int x;
    private int y;


    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2d getNewVector2d(WorldDirections direction){
        switch (direction){
            case NORTH -> {
                return new Vector2d(x, Math.floorMod(y-1,10));
            }
            case SOUTH -> {
                return new Vector2d(x, Math.floorMod(y+1,10));
            }
            case WEST -> {
                return new Vector2d(Math.floorMod(x-1,10), y);
            }
            case EAST -> {
                return new Vector2d(Math.floorMod(x + 1, 10), y);
            }
            default -> {
                return this;
            }
        }
    }

    @Override
    public String toString() {
        return "( " + x + ", " + y + " )";
    }

    public boolean equals(Object other){
        if(this == other)
            return true;
        if(!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;

        if(that.x != x)
            return false;
        if(that.y != y)
            return false;

        return true;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.x, this.y);
    }
}
