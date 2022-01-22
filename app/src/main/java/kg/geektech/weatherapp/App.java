package kg.geektech.weatherapp;

import android.app.Application;

import kg.geektech.weatherapp.data.remote.RetrofitClient;
import kg.geektech.weatherapp.data.remote.WeatherAppApi;
import kg.geektech.weatherapp.data.repositories.MainRepository;

public class App extends Application {

    private RetrofitClient client;
    private WeatherAppApi api;
    public static MainRepository repository;


    @Override
    public void onCreate() {
        super.onCreate();
        client = new RetrofitClient();
        api = client.provideApi();
        repository = new MainRepository(api);
    }
}
