package gasmi.monteleone.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Benjamin on 14/03/2017.
 */

public class CityWeather implements JsonDeserializer<CityWeather> {

    private String main;
    private String weather;

    private int id;
    private String description;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CityWeather{" +
                "main='" + main + '\'' +
                ", weather='" + weather + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public CityWeather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CityWeather cw = new CityWeather();
        JsonObject jsonObject = json.getAsJsonObject();

        JsonArray weatherArray = jsonObject.get("weather").getAsJsonArray();
        JsonObject weatherObj = weatherArray.get(0).getAsJsonObject();

        cw.setDescription(weatherObj.get("description").getAsString());

        return cw;
    }


}


