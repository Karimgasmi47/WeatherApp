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

    private String weatherMain;
    private String weather;

    private int weatherId;
    private String weatherDescription;

    public String getMain() {
        return weatherMain;
    }

    public void setMain(String main) {
        this.weatherMain = main;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getId() {
        return weatherId;
    }

    public void setId(int id) {
        this.weatherId = id;
    }

    public String getDescription() {
        return weatherDescription;
    }

    public void setDescription(String description) {
        this.weatherDescription = description;
    }

    @Override
    public String toString() {
        return "CityWeather{" +
                "main='" + weatherMain + '\'' +
                ", weather='" + weather + '\'' +
                ", id=" + weatherId +
                ", description='" + weatherDescription + '\'' +
                '}';
    }

    @Override
    public CityWeather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CityWeather cw = new CityWeather();
        JsonObject jsonObject = json.getAsJsonObject();

        JsonArray weatherArray = jsonObject.get("weather").getAsJsonArray();
        JsonObject weatherObj = weatherArray.get(0).getAsJsonObject();



        cw.setDescription(weatherObj.get("description").getAsString());
        cw.setMain(weatherObj.get("id").getAsString());

        return cw;
    }


}


