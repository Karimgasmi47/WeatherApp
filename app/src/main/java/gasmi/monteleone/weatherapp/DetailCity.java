package gasmi.monteleone.weatherapp;

import android.icu.util.DateInterval;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

        final TextView description = (TextView) findViewById(R.id.description);
        final TextView nom = (TextView) findViewById(R.id.nom);
        final TextView meteo = (TextView) findViewById(R.id.meteo);

        // Instantiate the RequestQueue.
        String url ="http://api.openweathermap.org/data/2.5/weather?id=" + city.getId() + "&appid=" + API_KEY;

        GsonRequest<CityWeather> request = new GsonRequest<>(url, CityWeather.class, null,
                new Response.Listener<CityWeather>() {
                    @Override
                    public void onResponse( CityWeather response) {

                        // Traiter la réponse ici
                        Log.d("CityName :", response.toString());

                        description.setText("Description :" +String.valueOf(response.getDescription()));



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // Traitement de l'erreur
                        Toast.makeText(DetailCity.this, "Erreur", Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);



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
