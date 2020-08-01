package com.exercice.weatherapp.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.exercice.weatherapp.R;
import com.exercice.weatherapp.models.DataToShow;
import com.exercice.weatherapp.util.IconProvider;
import com.exercice.weatherapp.util.Utils;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private TextView temp;
    private TextView date;
    private TextView maxTemp;
    private TextView minTemp;
    private ImageView imageView;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.date);
        maxTemp = itemView.findViewById(R.id.temp_max);
        temp = itemView.findViewById(R.id.temp);
        minTemp = itemView.findViewById(R.id.temp_min);
        imageView = itemView.findViewById(R.id.weather_icon);
    }

    public void updateWithWeatherData(DataToShow dataToShow) {
        this.date.setText(Utils.getDateString(dataToShow.getDate()));
        this.temp.setText(Utils.kelvinToCelsius(dataToShow.getTemp()));
        this.maxTemp.setText(Utils.kelvinToCelsius(dataToShow.getMaxTemp()));
        this.minTemp.setText(Utils.kelvinToCelsius(dataToShow.getMinTemp()));
        this.imageView.setImageResource(IconProvider.getImageIcon(dataToShow.getMain()));
    }
}