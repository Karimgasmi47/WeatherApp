package gasmi.monteleone.weatherapp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Benjamin on 20/03/2017.
 */

public class CityDeserializer implements JsonDeserializer<CityWeather> {

    @Override
    public CityWeather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        CityWeather cityWeather = new CityWeather();

        //setAttributes...
            /*
        cityWeather.setMain(jsonObject.get("weather").getAsJsonObject().get("main").getAsString());
        cityWeather.setTemp(jsonObject.get("main").getAsJsonObject().get("temp").getAsString());
    */

        return cityWeather;

    }
}
