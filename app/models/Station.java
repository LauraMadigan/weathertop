package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import utility.Utility;

@Entity
public class Station extends Model
{
    public String getName() {
        return name;
    }

    public String name;

    public float latitude;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float longitude;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name, float latitude, float longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    //method to get the latest readings from arraylist 'readings'
    public Reading latestReading() {
        if (this.readings.size() == 0) {
            return null;
        } else {
            return this.readings.get(this.readings.size() - 1);
        }
    }

    public String labelWindDirection() {
        Reading reading = this.latestReading();
        String windDirectionLabel = Utility.labelWindDirection(reading.getWindDirection());
        return windDirectionLabel;
    }

    public int labelWindChill() {
        Reading reading = this.latestReading();
        float windChill = Utility.calculateWindChill(reading.getTemperature(), reading.getWindSpeed());
        int roundedWindChill = Math.round(windChill);
        return roundedWindChill;
    }
}

