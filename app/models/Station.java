package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import utility.Calculation;
import utility.StationAnalytics;

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

    //method to get the latest readings for this station from arraylist 'readings'
    public Reading latestReading() {
        if (this.readings.size() == 0) {
            return null;
        } else {
            return this.readings.get(this.readings.size() - 1);
        }
    }

    public String labelWindDirection() {
        Reading reading = this.latestReading();
        String windDirectionLabel = Calculation.labelWindDirection(reading.getWindDirection());
        return windDirectionLabel;
    }

    public int labelWindChill() {
        Reading reading = this.latestReading();
        float windChill = Calculation.windChill(reading.getTemperature(), reading.getWindSpeed());
        int roundedWindChill = Math.round(windChill);
        return roundedWindChill;
    }

    public float getMaxTemperature() {
        return StationAnalytics.getMaxTemperature(this.readings);
    }

    public float getMaxPressure() {
        return StationAnalytics.getMaxPressure(this.readings);
    }

    public float getMaxWindSpeed () {
        return StationAnalytics.getMaxWindSpeed(this.readings);
    }

    public float getMinTemperature() {
        return StationAnalytics.getMinTemperature(this.readings);
    }

    public float getMinPressure() {
        return StationAnalytics.getMinPressure(this.readings);
    }

    public float getMinWindSpeed () {
        return StationAnalytics.getMinWindSpeed(this.readings);
    }


    //using sublist to collect the last 3 readings (to use for trends)
    public List<Reading> trendReadings(int readingSize) {
        int startIndex = Math.max(0, readings.size() - readingSize);
        return readings.subList(startIndex, readings.size());
    }

//    Weather trend analytic methods
    public static boolean checkWindAscending(List<Reading> readings)
    {
        if(readings.size() < 3) //there are not enough readings to do this
        {
            return false;
        }

        int lastReading = readings.size() -1;
        int secondLastReading = readings.size() -2;
        int thirdLastReading = readings.size() -3;

        float lastWindSpeed = readings.get(lastReading).getWindSpeed();
        float secondLastWindSpeed = readings.get(secondLastReading).getWindSpeed();
        float thirdLastWindSpeed = readings.get(thirdLastReading).getWindSpeed();

        if ((lastWindSpeed > secondLastWindSpeed) && (secondLastWindSpeed > thirdLastWindSpeed))
        {
            return true;    //wind speed is increasing
        }
        else return false;  //wind speed is not increasing
    }

    public static boolean checkWindDescending(List<Reading> readings)
    {
        if(readings.size() < 3) //there are not enough readings to do this
        {
            return false;
        }

        int lastReading = readings.size() -1;
        int secondLastReading = readings.size() -2;
        int thirdLastReading = readings.size() -3;

        float lastWindSpeed = readings.get(lastReading).getWindSpeed();
        float secondLastWindSpeed = readings.get(secondLastReading).getWindSpeed();
        float thirdLastWindSpeed = readings.get(thirdLastReading).getWindSpeed();

        if ((lastWindSpeed < secondLastWindSpeed) && (secondLastWindSpeed < thirdLastWindSpeed))
        {
            return true;    //wind speed is decreasing
        }
        else return false;  //wind speed is not decreasing
    }

    public String selectWindArrowTrend()
    {
        boolean descending = checkWindDescending(this.readings);
        boolean ascending = checkWindAscending(this.readings);

        if(descending) {
            return "fa-solid fa-arrow-down";
        }
        else if (ascending) {
            return "fa-solid fa-arrow-up";
        }
        return "";
    }

    public static boolean checkTemperatureAscending(List<Reading> readings)
    {
        if(readings.size() < 3) //there are not enough readings to do this
        {
            return false;
        }

        int lastReading = readings.size() -1;
        int secondLastReading = readings.size() -2;
        int thirdLastReading = readings.size() -3;

        float lastTemperature = readings.get(lastReading).getTemperature();
        float secondLastTemperature = readings.get(secondLastReading).getTemperature();
        float thirdLastTemperature = readings.get(thirdLastReading).getTemperature();

        if ((lastTemperature > secondLastTemperature) && (secondLastTemperature > thirdLastTemperature))
        {
            return true;    //temperature is increasing
        }
        else return false;  //temperature is not increasing
    }

    public static boolean checkTemperatureDescending(List<Reading> readings)
    {
        if(readings.size() < 3) //there are not enough readings to do this
        {
            return false;
        }

        int lastReading = readings.size() -1;
        int secondLastReading = readings.size() -2;
        int thirdLastReading = readings.size() -3;

        float lastTemperature = readings.get(lastReading).getTemperature();
        float secondLastTemperature = readings.get(secondLastReading).getTemperature();
        float thirdLastTemperature = readings.get(thirdLastReading).getTemperature();

        if ((lastTemperature < secondLastTemperature) && (secondLastTemperature < thirdLastTemperature))
        {
            return true;    //temperature is decreasing
        }
        else return false;  //temperature is not decreasing
    }

    public String selectTemperatureArrowTrend()
    {
        boolean descending = checkTemperatureDescending(this.readings);
        boolean ascending = checkTemperatureAscending(this.readings);

        if(descending) {
            return "fa-solid fa-arrow-down";
        }
        else if (ascending) {
            return "fa-solid fa-arrow-up";
        }
        return "";
    }

    public static boolean checkPressureAscending(List<Reading> readings)
    {
        if(readings.size() < 3) //there are not enough readings to do this
        {
            return false;
        }

        int lastReading = readings.size() -1;
        int secondLastReading = readings.size() -2;
        int thirdLastReading = readings.size() -3;

        float lastPressure = readings.get(lastReading).getPressure();
        float secondLastPressure = readings.get(secondLastReading).getPressure();
        float thirdLastPressure = readings.get(thirdLastReading).getPressure();

        if ((lastPressure > secondLastPressure) && (secondLastPressure > thirdLastPressure))
        {
            return true;    //pressure is increasing
        }
        else return false;  //pressure is not increasing
    }


    public static boolean checkPressureDescending(List<Reading> readings)
    {
        if (readings.size() < 3) //there are not enough readings to do this
        {
            return false;
        }

        int lastReading = readings.size() -1;
        int secondLastReading = readings.size() -2;
        int thirdLastReading = readings.size() -3;

        float lastPressure = readings.get(lastReading).getPressure();
        float secondLastPressure = readings.get(secondLastReading).getPressure();
        float thirdLastPressure = readings.get(thirdLastReading).getPressure();

        if ((lastPressure < secondLastPressure) && (secondLastPressure < thirdLastPressure))
        {
            return true;    //pressure is decreasing
        }
        else return false;  //pressure is not decreasing
    }

    public String selectPressureArrowTrend()
    {
        boolean descending = checkPressureDescending(this.readings);
        boolean ascending = checkPressureAscending(this.readings);

        if(descending) {
            return "fa-solid fa-arrow-down";
        }
        else if (ascending) {
            return "fa-solid fa-arrow-up";
        }
        return "";
    }

}

