package com.exercice.weatherapp.di.weatherapi;

import com.exercice.weatherapp.network.WeatherApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class MainModule {

    @Provides
    static WeatherApi provideSessionApi(Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }
}
