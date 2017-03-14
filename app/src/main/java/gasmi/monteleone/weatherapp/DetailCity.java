package gasmi.monteleone.weatherapp;

import android.icu.util.DateInterval;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DetailCity extends AppCompatActivity {

    private static final String API_KEY = "7a63917e201cd89d9c3745bce9bc550f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_city);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        City city = getIntent().getParcelableExtra("city");
        Coord coordo = getIntent().getParcelableExtra("coord");
        //Double lat = getIntent().getDoubleExtra("lat", 0.0);
        //Double lon = getIntent().getDoubleExtra("long", 0.0);

        final TextView nom = (TextView) findViewById(R.id.nom);
        final TextView meteo = (TextView) findViewById(R.id.meteo);
//      TextView coord = (TextView) findViewById(R.id.coord);

//      nom.setText(city.getCountry() + " - " +city.getName());
//      coord.setText("Long : " + city.getCoord().getLongitude() + "\nLat : " + city.getCoord().getLatitude());
//      coord.setText("\nLong : "+ coordo.getLatitude() + "\nLat : " + coordo.getLongitude());


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/weather?id=" + city.getId() + "&appid=" + API_KEY;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Coucou c'est pour le push



                        // Display the first 500 characters of the response string.
                        //meteo.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailCity.this,"That didn't work!", Toast.LENGTH_LONG).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
