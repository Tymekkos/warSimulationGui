package com.company.stats;

public class ApplicationProperties {
    public static int BOUND = 10;
    public static int DAYS_NUMBER = 100;
    public static int CHARACTERS_NUMBER = 50;
    public static int MAX_CHARACTERS_AGE = 15;
    public static int TIME = 100;

    public static int getDaysNumber() {
        return DAYS_NUMBER;
    }

    public static void setDaysNumber(int daysNumber) {
        DAYS_NUMBER = daysNumber;
    }

    public static int getTime() {
        return TIME;
    }

    public static void setTime(int time) {
        ApplicationProperties.TIME = time;
    }
}
