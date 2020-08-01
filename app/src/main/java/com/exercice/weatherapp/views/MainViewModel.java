package com.exercice.weatherapp.views;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.exercice.weatherapp.models.WeatherData;
import com.exercice.weatherapp.network.WeatherApi;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";


    private final WeatherApi weatherApi;

    private MediatorLiveData<WeatherData> weatherDatas = new MediatorLiveData<>();

    @Inject
    public MainViewModel(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public void getWeatherData(String appid) {
        final LiveData<WeatherData> source = LiveDataReactiveStreams.fromPublisher(
                weatherApi.getParisWeather(appid)
                        .subscribeOn(Schedulers.io()));

        weatherDatas.addSource(source, new Observer<WeatherData>() {
            @Override
            public void onChanged(WeatherData weatherData) {
                weatherDatas.setValue(weatherData);
                weatherDatas.removeSource(source);
            }
        });
    }

    public LiveData<WeatherData> observeWeather() {
        return weatherDatas;
    }

}
