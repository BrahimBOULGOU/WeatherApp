package com.exercice.weatherapp.models;

import java.util.List;

public class ListData {
    private long dt;
    private Temp temp;
    private List<Weather> weather;

    public long getDt() {
        return dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public List<Weather> getWeather() {
        return weather;
    }

}
