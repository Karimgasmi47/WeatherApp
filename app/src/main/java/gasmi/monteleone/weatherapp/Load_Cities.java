package gasmi.monteleone.weatherapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static gasmi.monteleone.weatherapp.FirstActivity.cities;
import static java.security.AccessController.getContext;

/**
 * Created by Benjamin on 29/03/2017.
 */

public class Load_Cities extends AsyncTask<ArrayList<City>, Void, ArrayList<City>> {

    InputStream is = null;
    BufferedReader reader = null;
    AssetManager assetManager;
    Context context;
    ProgressDialog pdLoading;

    public Load_Cities(Context myContext) {
        this.context = myContext;
        assetManager = context.getAssets();
        pdLoading = new ProgressDialog(context, ProgressDialog.STYLE_SPINNER);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //this method will be running on UI thread
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();

    }

    @Override
    protected ArrayList<City> doInBackground(ArrayList<City>... params) {
        Gson gson = new Gson();
        Log.e("TEST", "Rien");
        try {
            is = assetManager.open("city_france.json");
            reader = new BufferedReader(new InputStreamReader(is));
            //json_file_string = reader.readLine();
            String line = null;
            while( (line = reader.readLine()) != null) {
                cities.add(gson.fromJson(line, City.class));
            }

        } catch (final Exception e){
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignored) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
        return cities;
    }

    protected void onPostExecute(ArrayList<City> result) {
        super.onPostExecute(result);
        pdLoading.dismiss();
    }
}
