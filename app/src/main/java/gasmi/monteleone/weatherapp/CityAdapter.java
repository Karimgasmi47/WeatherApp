package gasmi.monteleone.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by DUT on 13/03/2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityHolder>{

    private static final String TAG = "CityAdapter";
    private ArrayList<City> items;
    private OnCityListener listener;

    public interface OnCityListener {
        void onCityClick(City city);
        void onCityLongClick(City city);
    }

    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_city, parent, false);

        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        City city = items.get(position);
        holder.bind(city, listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
