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

    private String mainTemp;
    private String mainPressure;
    private String mainHumidity;
    private String mainTemp_min;
    private String mainTemp_max;

    public String getMainTemp_max() {
        return mainTemp_max;
    }

    public void setMainTemp_max(String mainTemp_max) {
        this.mainTemp_max = mainTemp_max;
    }

    public String getMainTemp_min() {
        return mainTemp_min;
    }

    public void setMainTemp_min(String mainTemp_min) {
        this.mainTemp_min = mainTemp_min;
    }

    public String getMainHumidity() {
        return mainHumidity;
    }

    public void setMainHumidity(String mainHumidity) {
        this.mainHumidity = mainHumidity;
    }

    public String getMainPressure() {
        return mainPressure;
    }

    public void setMainPressure(String mainPressure) {
        this.mainPressure = mainPressure;
    }

    public String getMainTemp() {
        return mainTemp;
    }

    public void setMainTemp(String mainTemp) {
        this.mainTemp = mainTemp;
    }

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
                "weatherMain='" + weatherMain + '\'' +
                ", weather='" + weather + '\'' +
                ", mainTemp=" + mainTemp +
                ", mainPressure=" + mainPressure +
                ", mainHumidity=" + mainHumidity +
                ", mainTemp_min=" + mainTemp_min +
                ", mainTemp_max=" + mainTemp_max +
                ", weatherId=" + weatherId +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
    }

    @Override
    public CityWeather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CityWeather cw = new CityWeather();
        JsonObject jsonObject = json.getAsJsonObject();

        JsonArray weatherArray = jsonObject.get("weather").getAsJsonArray();
        JsonObject weatherObj = weatherArray.get(0).getAsJsonObject();

        JsonObject mainObj = jsonObject.get("main").getAsJsonObject();




        cw.setDescription(weatherObj.get("description").getAsString());
        cw.setMain(weatherObj.get("main").getAsString());
        cw.setMainTemp(mainObj.get("temp").getAsString());
        cw.setMainPressure(mainObj.get("pressure").getAsString());
        cw.setMainHumidity(mainObj.get("humidity").getAsString());
        cw.setMainTemp_min(mainObj.get("temp_min").getAsString());
        cw.setMainTemp_max(mainObj.get("temp_max").getAsString());

        return cw;
    }


}


