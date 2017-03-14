package gasmi.monteleone.weatherapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DUT on 27/02/2017.
 */

public class Coord implements Parcelable{
    private double lat;
    private double lon;

    public Coord(double latitude, double longitude) {
        this.lat = latitude;
        this.lon = longitude;
    }

    protected Coord(Parcel in) {
        lat = in.readDouble();
        lon = in.readDouble();
    }

    public static final Creator<Coord> CREATOR = new Creator<Coord>() {
        @Override
        public Coord createFromParcel(Parcel in) {
            return new Coord(in);
        }

        @Override
        public Coord[] newArray(int size) {
            return new Coord[size];
        }
    };

    public double getLatitude() {
        return lat;
    }

    public double getLongitude() {
        return lon;
    }

    public void setLatitude(double latitude) {
        this.lat = latitude;
    }

    public void setLongitude(double longitude) {
        this.lon = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lon);
    }
}
