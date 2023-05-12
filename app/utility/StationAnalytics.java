package utility;

import models.Reading;

import java.util.List;

public class StationAnalytics {

  public static float getMaxTemperature(List<Reading> readings) {
    float maxTemperature = -1000;
    for (Reading reading : readings) {
      if (reading.getTemperature() > maxTemperature) {
        maxTemperature = reading.getTemperature();
      }
    }
    return maxTemperature;
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

}





