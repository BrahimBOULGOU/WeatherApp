package com.exercice.weatherapp.util;

import com.exercice.weatherapp.R;

public class IconProvider {
    public static int getImageIcon(String weatherDescription) {
        int weatherIcon;
        switch (weatherDescription) {
            case "Thunderstorm":
                weatherIcon = R.drawable.ic_thunderstorm;
                break;
            case "Drizzle":
                weatherIcon = R.drawable.ic_drizzle;
                break;
            case "Rain":
                weatherIcon = R.drawable.ic_rain;
                break;
            case "Snow":
                weatherIcon = R.drawable.ic_snow;
                break;
            case "Atmosphere":
                weatherIcon = R.drawable.ic_atmosphere;
                break;
            case "Clear":
                weatherIcon = R.drawable.ic_clear;
                break;
            case "Clouds":
                weatherIcon = R.drawable.ic_cloudy;
                break;
            case "Extreme":
                weatherIcon = R.drawable.ic_extreme;
                break;
            default:
                weatherIcon = R.drawable.ic_clear;
        }
        return weatherIcon;

    }

}
