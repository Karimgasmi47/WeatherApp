package gasmi.monteleone.weatherapp;

/**
 * Created by DUT on 27/02/2017.
 */

public class Coord {
    private String latitude;
    private String longitude;

    public Coord(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
