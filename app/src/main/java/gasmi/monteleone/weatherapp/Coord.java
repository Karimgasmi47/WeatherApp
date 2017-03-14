package gasmi.monteleone.weatherapp;

/**
 * Created by DUT on 27/02/2017.
 */

public class Coord {
    private Double latitude;
    private Double longitude;

    public Coord(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
