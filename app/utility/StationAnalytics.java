package utility;

import models.Reading;

import java.util.List;

public class StationAnalytics {


  public static float getMaxTemperature(List<Reading> readings) { //calculates the max temp from all the readings in the array
    float maxTemperature = -1000;                                 //initialising to low number to allow lots of range
    for (Reading reading : readings) {                            //for each loop runs through the readings
      if (reading.getTemperature() > maxTemperature) {            //if the temperature of the current reading is > current max temp
        maxTemperature = reading.getTemperature();                //assign it as the new max temp
      }
    }
    return maxTemperature;                                        //return max temp
  }

  public static float getMaxWindSpeed(List<Reading> readings) {
    float maxWindSpeed = 0;
    for (Reading reading : readings) {
      if (reading.getWindSpeed() > maxWindSpeed) {
        maxWindSpeed = reading.getWindSpeed();
      }
    }
    return maxWindSpeed;
  }

  public static float getMaxPressure(List<Reading> readings) {
    float maxPressure = 0;
    for (Reading reading : readings) {
      if (reading.getPressure() > maxPressure) {
        maxPressure = reading.getPressure();
      }
    }
    return maxPressure;
  }

  public static float getMinTemperature(List<Reading> readings) {
    float minTemperature = 1000;
    for (Reading reading : readings) {
      if (reading.getTemperature() < minTemperature) {
        minTemperature = reading.getTemperature();
      }
    }
    return minTemperature;
  }

  public static float getMinWindSpeed(List<Reading> readings) {
    float minWindSpeed = 500;
    for (Reading reading : readings) {
      if (reading.getWindSpeed() < minWindSpeed) {
        minWindSpeed = reading.getWindSpeed();
      }
    }
    return minWindSpeed;
  }

  public static float getMinPressure(List<Reading> readings) {
    float minPressure = 1050;
    for (Reading reading : readings) {
      if (reading.getPressure() < minPressure) {
        minPressure = reading.getPressure();
      }
    }
    return minPressure;
  }

  //Weather trend analytic methods
  public static boolean checkWindAscending(List<Reading> readings) {
    if (readings.size() < 3)  //there are not enough readings to do this
    {
      return false;
    }
    //getting the last 3 readings
    int lastReading = readings.size() - 1;
    int secondLastReading = readings.size() - 2;
    int thirdLastReading = readings.size() - 3;
    //getting the last 3 windSpeeds for those readings
    float lastWindSpeed = readings.get(lastReading).getWindSpeed();
    float secondLastWindSpeed = readings.get(secondLastReading).getWindSpeed();
    float thirdLastWindSpeed = readings.get(thirdLastReading).getWindSpeed();
    //if last wind speed is greater than both second and third last ones
    if ((lastWindSpeed > secondLastWindSpeed) && (secondLastWindSpeed > thirdLastWindSpeed)) {
      return true;    //wind speed is increasing
    } else return false;  //wind speed is not increasing
  }

  public static boolean checkWindDescending(List<Reading> readings) {
    if (readings.size() < 3) //there are not enough readings to do this
    {
      return false;
    }

    int lastReading = readings.size() - 1;
    int secondLastReading = readings.size() - 2;
    int thirdLastReading = readings.size() - 3;

    float lastWindSpeed = readings.get(lastReading).getWindSpeed();
    float secondLastWindSpeed = readings.get(secondLastReading).getWindSpeed();
    float thirdLastWindSpeed = readings.get(thirdLastReading).getWindSpeed();

    if ((lastWindSpeed < secondLastWindSpeed) && (secondLastWindSpeed < thirdLastWindSpeed)) {
      return true;    //wind speed is decreasing
    } else return false;  //wind speed is not decreasing
  }

  public static boolean checkTemperatureAscending(List<Reading> readings) {
    if (readings.size() < 3) //there are not enough readings to do this
    {
      return false;
    }

    int lastReading = readings.size() - 1;
    int secondLastReading = readings.size() - 2;
    int thirdLastReading = readings.size() - 3;

    float lastTemperature = readings.get(lastReading).getTemperature();
    float secondLastTemperature = readings.get(secondLastReading).getTemperature();
    float thirdLastTemperature = readings.get(thirdLastReading).getTemperature();

    if ((lastTemperature > secondLastTemperature) && (secondLastTemperature > thirdLastTemperature)) {
      return true;    //temperature is increasing
    } else return false;  //temperature is not increasing
  }

  public static boolean checkTemperatureDescending(List<Reading> readings) {
    if (readings.size() < 3) //there are not enough readings to do this
    {
      return false;
    }

    int lastReading = readings.size() - 1;
    int secondLastReading = readings.size() - 2;
    int thirdLastReading = readings.size() - 3;

    float lastTemperature = readings.get(lastReading).getTemperature();
    float secondLastTemperature = readings.get(secondLastReading).getTemperature();
    float thirdLastTemperature = readings.get(thirdLastReading).getTemperature();

    if ((lastTemperature < secondLastTemperature) && (secondLastTemperature < thirdLastTemperature)) {
      return true;    //temperature is decreasing
    } else return false;  //temperature is not decreasing
  }

  public static boolean checkPressureAscending(List<Reading> readings) {
    if (readings.size() < 3) //there are not enough readings to do this
    {
      return false;
    }

    int lastReading = readings.size() - 1;
    int secondLastReading = readings.size() - 2;
    int thirdLastReading = readings.size() - 3;

    float lastPressure = readings.get(lastReading).getPressure();
    float secondLastPressure = readings.get(secondLastReading).getPressure();
    float thirdLastPressure = readings.get(thirdLastReading).getPressure();

    if ((lastPressure > secondLastPressure) && (secondLastPressure > thirdLastPressure)) {
      return true;    //pressure is increasing
    } else return false;  //pressure is not increasing
  }

  public static boolean checkPressureDescending(List<Reading> readings) {
    if (readings.size() < 3) //there are not enough readings to do this
    {
      return false;
    }

    int lastReading = readings.size() - 1;
    int secondLastReading = readings.size() - 2;
    int thirdLastReading = readings.size() - 3;

    float lastPressure = readings.get(lastReading).getPressure();
    float secondLastPressure = readings.get(secondLastReading).getPressure();
    float thirdLastPressure = readings.get(thirdLastReading).getPressure();

    if ((lastPressure < secondLastPressure) && (secondLastPressure < thirdLastPressure)) {
      return true;    //pressure is decreasing
    } else return false;  //pressure is not decreasing
  }
}





