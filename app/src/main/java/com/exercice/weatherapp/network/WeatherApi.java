package com.exercice.weatherapp.network;

import com.exercice.weatherapp.models.WeatherData;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("data/2.5/forecast/daily?q=Paris,FR&appid")
    Flowable<WeatherData> getParisWeather(@Query("appid") String appid);
}
