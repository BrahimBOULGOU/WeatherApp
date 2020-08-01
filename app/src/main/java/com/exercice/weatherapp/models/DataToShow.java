package com.exercice.weatherapp.models;

public class DataToShow {
    private long date;
    private float temp;
    private float maxTemp;
    private float minTemp;
    private String main;

    public DataToShow(long date, float temp, float maxTemp, float minTemp, String main) {
        this.date = date;
        this.temp = temp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.main = main;
    }

    public long getDate() {
        return date;
    }

    public float getTemp() {
        return temp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public String getMain() {
        return main;
    }
}
