package gasmi.monteleone.weatherapp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class FirstActivity extends AppCompatActivity {

    private CityAdapter adapter;
    static ArrayList<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        // Objets pour récuperer le contenu du fichier json (les villes)
        String json_file_string = "";

        InputStream is = null;
        BufferedReader reader = null;
        AssetManager assetManager = getAssets();
        new Load_Cities(this).execute(cities);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        */

            // Création de l'Adapter avec pour paramètre la liste des Users (passage par référence !!!) et un Listener pour gérer le clic
            adapter = new CityAdapter(cities, new CityAdapter.OnCityListener(){
                @Override
                public void onCityClick(City city) {
                    // Action lors du clic sur un item de la liste
                    Intent intent = new Intent(FirstActivity.this, DetailCity.class);
                    intent.putExtra("city", city);
                    intent.putExtra("coord", city.getCoord());
                    startActivity(intent);

                }

                @Override
                public void onCityLongClick(City city) {
                    // Autre action lors du clic long sur un item de la liste
                    Toast.makeText(FirstActivity.this, city.getName() + " - " + city.getCountry(), Toast.LENGTH_LONG).show();
                }
            });

            // Récupération du recyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

            // Affectation du LayoutManager
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

            // Affectation de l'Adapter
            recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
