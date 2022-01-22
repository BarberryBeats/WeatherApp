package kg.geektech.weatherapp.data.remote;

import kg.geektech.weatherapp.data.models.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherAppApi {

    @GET("weather")
    Call<MainResponse> getWeather();
}
