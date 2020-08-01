package com.exercice.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.exercice.weatherapp.R;
import com.exercice.weatherapp.models.DataToShow;
import com.exercice.weatherapp.views.WeatherViewHolder;

import java.util.List;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private List<DataToShow> dataToShows;

    public WeatherAdapter(List<DataToShow> dataToShows) {
        this.dataToShows = dataToShows;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.weather_item, parent, false);

        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder viewHolder, int position) {
        viewHolder.updateWithWeatherData(this.dataToShows.get(position));
    }

    @Override
    public int getItemCount() {
        return this.dataToShows.size();
    }
}