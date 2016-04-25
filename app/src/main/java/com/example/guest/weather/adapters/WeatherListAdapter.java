package com.example.guest.weather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.weather.R;
import com.example.guest.weather.models.Weather;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/25/16.
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder> {
    private ArrayList<Weather> mWeather = new ArrayList<>();
    private Context mContext;

    public WeatherListAdapter(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeather = weathers;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeather.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeather.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.weatherImageView) ImageView mWeatherImageView;
        @Bind(R.id.weatherMaxTextView) TextView mMaxTextView;
        private Context mContext;


        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(Weather weather) {
            mMaxTextView.setText("High Temp of " + weather.getMaxTemp());
        }
    }
}
