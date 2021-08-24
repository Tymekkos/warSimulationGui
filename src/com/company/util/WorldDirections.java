package com.company.util;

import java.util.Random;

public enum WorldDirections {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public static WorldDirections getRandomDirection(){
        Random random = new Random();
        int dir = random.nextInt(3);

        return switch(dir) {
            case 1 -> WorldDirections.SOUTH;
            case 2 -> WorldDirections.WEST;
            case 3 -> WorldDirections.EAST;
            default -> WorldDirections.NORTH;
        };
    }
}
