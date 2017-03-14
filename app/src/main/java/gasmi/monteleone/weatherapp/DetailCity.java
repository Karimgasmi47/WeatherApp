package gasmi.monteleone.weatherapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailCity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_city);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        City city = getIntent().getParcelableExtra("city");
        TextView nom = (TextView) findViewById(R.id.nom);
        TextView coord = (TextView) findViewById(R.id.coord);
        TextView country = (TextView) findViewById(R.id.country);

        coord.setText(city.getName() + "\nLong : " + city.getCoord().getLongitude() + "\nLat : " + city.getCoord().getLatitude());
    }
}
