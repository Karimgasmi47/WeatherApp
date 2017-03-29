package gasmi.monteleone.weatherapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.icu.util.DateInterval;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

import static java.lang.Integer.parseInt;
import static java.lang.Math.round;

public class DetailCity extends AppCompatActivity {

    private static final String API_KEY = "7a63917e201cd89d9c3745bce9bc550f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_city);

        final DecimalFormat df2 = new DecimalFormat(".##");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final City city = getIntent().getParcelableExtra("city");
        final Coord coordo = getIntent().getParcelableExtra("coord");
        final Double l1 = coordo.getLatitude();
        final Double l2 = coordo.getLongitude();

        setTitle(city.getName());

        final TextView weatherDescription = (TextView) findViewById(R.id.weatherDescription);
        final ImageView weatherIcon = (ImageView) findViewById(R.id.iconWeather);
        // final TextView weatherMain = (TextView) findViewById(R.id.weatherMain);
        final TextView mainHumidity = (TextView) findViewById(R.id.mainHumidity);
        final TextView mainPressure = (TextView) findViewById(R.id.mainPressure);
        final TextView mainTemp = (TextView) findViewById(R.id.mainTemp);
        final TextView visibility = (TextView) findViewById(R.id.visibility);
        final TextView windSpeed = (TextView) findViewById(R.id.windSpeed);

        // Instantiate the RequestQueue.
        String url ="http://api.openweathermap.org/data/2.5/weather?id=" + city.getId() + "&appid=" + API_KEY;

        GsonRequest<CityWeather> request = new GsonRequest<>(url, CityWeather.class, null,
                new Response.Listener<CityWeather>() {
                    @Override
                    public void onResponse(CityWeather response) {

                        //Log.d("CityName :", response.toString());

                        String wDescritption = response.getDescription();
                        /* Valeur possible :
                         *     Light Rain
                         *     Clear Sky
                         *     Overcast Clouds
                         *     Moderate Rain
                         *     Scattered clouds
                         *     Few Clouds
                         *     ...
                         */

                        weatherDescription.setText(String.valueOf(wDescritption));

                        String main = response.getMain();

                        Glide.with(DetailCity.this).load("http://openweathermap.org/img/w/" + response.getWeatherIcon() +".png").into(weatherIcon);

                        mainHumidity.setText(String.valueOf(response.getMainHumidity()) + " %");
                        mainPressure.setText(String.valueOf(response.getMainPressure()) + " mb");

                        String mTempStr = response.getMainTemp();
                        Double mTemp = Double.parseDouble(mTempStr.toString());
                        mTemp -= 273.15;
                        mTemp = Double.valueOf(round(mTemp));
                        mainTemp.setText(String.valueOf(mTemp) + "°C");

                        String vis = response.getVisibility();
                        int visib = Integer.valueOf(vis);
                        if (visib > 1000) {
                            vis = vis.substring(0, 2) + " km";
                        } else {
                            vis = response.getVisibility() + " m";
                        }

                        visibility.setText(String.valueOf(vis));
                        windSpeed.setText(String.valueOf(response.getWindSpeed()) + " km/h");

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

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*fab.setImageResource(R.drawable.ic_pin_drop_black_24dp);
                Snackbar.make(view, "Replace with action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(DetailCity.this, MapsActivity.class);
                intent.putExtra("Lat", l1);
                intent.putExtra("Lng", l2);
                startActivity(intent);
            }
        });
    }
}
