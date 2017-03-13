package gasmi.monteleone.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Benjamin on 13/03/2017.
 */

public class CityHolder extends RecyclerView.ViewHolder{
    private View view;
    private TextView nomView;
    private TextView countryView;


    private City city;

    // Constructeur
    public CityHolder(View itemView) {
        super(itemView);

        view = itemView;
        nomView = (TextView) view.findViewById(R.id.nom);
        countryView = (TextView) view.findViewById(R.id.country);

    }

    // Méthode qui lie les données du User aux champs correspondant ainsi que le listener
    public void bind(City city) {
        this.city = city;

        // Modification des champs
        nomView.setText(city.getName());
        countryView.setText(city.getCountry());
/*
        // Affectation du listener
        if(listener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onUserClick(FileHolder.this.file);
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onUserLongClick(FileHolder.this.file);
                    return false;
                }
            });
        }*/
    }
}
