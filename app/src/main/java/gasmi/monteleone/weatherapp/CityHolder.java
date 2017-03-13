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


    private City city;

    // Constructeur
    public CityHolder(View itemView) {
        super(itemView);

        view = itemView;
        nomView = (TextView) view.findViewById(R.id.nom);

    }

    // Méthode qui lie les données des City aux champs correspondant ainsi que le listener
    public void bind(City city, final CityAdapter.OnCityListener listener) {
        this.city = city;

        // Modification des champs
        nomView.setText(city.getName());

        // Affectation du listener
        if(listener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCityClick(CityHolder.this.city);
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onCityLongClick(CityHolder.this.city);
                    return false;
                }
            });
        }
    }
}
