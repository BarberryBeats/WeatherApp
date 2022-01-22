package kg.geektech.weatherapp.ui.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kg.geektech.weatherapp.R;
import kg.geektech.weatherapp.base.BaseFragment;
import kg.geektech.weatherapp.common.Resource;
import kg.geektech.weatherapp.data.models.MainResponse;
import kg.geektech.weatherapp.databinding.FragmentWeatherAppBinding;

public class WeatherAppFragment extends BaseFragment<FragmentWeatherAppBinding> {

    private WeatherViewModel viewModel;
    private MainResponse weather;


    @Override
    protected FragmentWeatherAppBinding bind() {
        return FragmentWeatherAppBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupObservers() {
        viewModel.weatherLiveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponse>>() {
            @Override
            public void onChanged(Resource<MainResponse> resource) {
                switch (resource.status){
                    case SUCCESS:{
                       setupUI(resource.data.getWeather());
                        break;
                    }
                    case ERROR:{
                        break;
                    }
                    case LOADING:{
                        break;
                    }
                }
            }
        });
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);


    }

    @Override
    protected void callRequests() {
        viewModel.getWeather();
    }
    public void setupUI(MainResponse weather) {
        this.weather = weather;
        binding.testt.setText(weather.getName());
    }
}