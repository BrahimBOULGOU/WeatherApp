package com.exercice.weatherapp.di;

import com.exercice.weatherapp.di.weatherapi.MainModule;
import com.exercice.weatherapp.di.weatherapi.MainViewModelsModule;
import com.exercice.weatherapp.views.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
