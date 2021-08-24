package com.company.factory;

import com.company.util.Vector2d;

import java.util.Random;

public class RandomVector2dFactory {
    public static Vector2d getRandomVector2d(int bound){
        Random random = new Random();
        return new Vector2d(random.nextInt(bound), random.nextInt(bound));
    }
    public static Vector2d getFieldAroundTheVector2d(Vector2d field, int bound){
        Random random = new Random();
        switch (random.nextInt(8)) {
            //north
            case 0 -> {
                if (field.getY() + 1 >= bound) {
                    return new Vector2d(field.getX(), 0);
                } else {
                    return new Vector2d(field.getX(), field.getY() + 1);
                }
            }

            //north east
            case 1 -> {
                if (field.getX() + 1 >= bound && field.getY() + 1 >= bound) {
                    return new Vector2d(0, 0);
                } else if (field.getX() + 1 >= bound) {
                    return new Vector2d(0, field.getY());
                } else if (field.getY() + 1 >= bound) {
                    return new Vector2d(field.getX(), 0);
                } else {
                    return new Vector2d(field.getX() + 1, field.getY() + 1);
                }
            }
            //east
            case 2 -> {
                if (field.getX() + 1 >= bound) {
                    return new Vector2d(0, field.getY());
                } else {
                    return new Vector2d(field.getX() + 1, field.getY());
                }
            }

            //south east
            case 3 -> {
                if (field.getX() + 1 >= bound && field.getY() - 1 < 0) {
                    return new Vector2d(0, bound - 1);
                } else if (field.getX() + 1 >= bound) {
                    return new Vector2d(0, field.getY());
                } else if (field.getY() - 1 < 0) {
                    return new Vector2d(field.getX(), bound - 1);
                } else {
                    return new Vector2d(field.getX() + 1, field.getY() - 1);
                }
            }

            //south
            case 4 -> {
                if (field.getY() - 1 < 0) {
                    return new Vector2d(field.getX(), bound - 1);
                } else {
                    return new Vector2d(field.getX(), field.getY() - 1);
                }
            }
            // south west
            case 5 -> {
                if (field.getX() - 1 < 0 && field.getY() - 1 < 0) {
                    return new Vector2d(bound - 1, bound - 1);
                } else if (field.getX() - 1 < 0) {
                    return new Vector2d(bound - 1, field.getY());
                } else if (field.getY() - 1 < 0) {
                    return new Vector2d(field.getX(), bound - 1);
                } else {
                    return new Vector2d(field.getX() - 1, field.getY() - 1);
                }
            }

            // west
            case 6 -> {
                if (field.getX() - 1 < 0) {
                    return new Vector2d(bound - 1, field.getY());
                } else {
                    return new Vector2d(field.getX() - 1, field.getY());
                }
            }

            // north west
            case 7 -> {
                if (field.getX() - 1 < 0 && field.getY() + 1 >= bound) {
                    return new Vector2d(bound - 1, 0);
                } else if (field.getX() - 1 < 0) {
                    return new Vector2d(bound - 1, field.getY());
                } else if (field.getY() + 1 >= bound) {
                    return new Vector2d(field.getX(), 0);
                } else {
                    return new Vector2d(field.getX() - 1, field.getY() + 1);
                }
            }
            default -> {
                return null;
            }
        }
    }
}