package com.exercice.weatherapp.di.weatherapi;

import androidx.lifecycle.ViewModel;

import com.exercice.weatherapp.di.ViewModelKey;
import com.exercice.weatherapp.views.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);
}
