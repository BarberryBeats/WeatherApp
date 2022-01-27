package kg.geektech.weatherapp.ui.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kg.geektech.weatherapp.data.models.modelsday.List;
import kg.geektech.weatherapp.databinding.ItemWeatherBinding;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private java.util.List<List> weatherNextDay = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWeatherBinding binding = ItemWeatherBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    public void setWeatherNextDay(java.util.List<List> weatherNextDay) {
        this.weatherNextDay = weatherNextDay;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.onBind(weatherNextDay.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherNextDay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemWeatherBinding binding;
        public ViewHolder(@NonNull ItemWeatherBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(List weatherNextDay1) {
binding.text1DayMaxTemp.setText(weatherNextDay1.getMain().getTempMax().toString());
        }
    }
}
