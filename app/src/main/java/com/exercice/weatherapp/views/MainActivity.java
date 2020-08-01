package com.exercice.weatherapp.views;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.exercice.weatherapp.R;
import com.exercice.weatherapp.adapter.WeatherAdapter;
import com.exercice.weatherapp.models.DataToShow;
import com.exercice.weatherapp.models.ListData;
import com.exercice.weatherapp.models.WeatherData;
import com.exercice.weatherapp.viewmodels.ViewModelProviderFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainViewModel viewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    private RecyclerView recyclerView;

    private List<DataToShow> dataToShows;
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recylerView);
        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);
        configureRecyclerView();
        subscribeObservers();
        getWeatherData();
    }

    private void subscribeObservers() {
        viewModel.observeWeather().observe(this, new Observer<WeatherData>() {
            @Override
            public void onChanged(WeatherData weatherData) {
                if (weatherData != null) {
                    updateUI(weatherData.getList());
                }
            }
        });
    }

    private void getWeatherData() {
        viewModel.getWeatherData(getResources().getString(R.string.appid));
    }

    private void configureRecyclerView() {
        this.dataToShows = new ArrayList<>();
        this.adapter = new WeatherAdapter(this.dataToShows);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void updateUI(List<ListData> listDatas) {
        for (ListData listData : listDatas) {
            dataToShows.add(new DataToShow(listData.getDt(),
                    listData.getTemp().getDay(),
                    listData.getTemp().getMax(),
                    listData.getTemp().getMin(),
                    listData.getWeather().get(0).getMain()));
        }
        adapter.notifyDataSetChanged();
    }
}
