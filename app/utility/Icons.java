package utility;

import models.Reading;

import java.util.HashMap;
import java.util.List;

public class Icons {


  //returns the appropriate icon for a given weather code
  public static String selectIconForConditions(int code) {
    HashMap<Integer, String> iconMap = new HashMap<>();
    iconMap.put(100, "fa-sun");
    iconMap.put(200, "fa-cloud-sun");
    iconMap.put(300, "fa-cloud");
    iconMap.put(400, "fa-cloud-sun-rain");
    iconMap.put(500, "fa-cloud-showers-heavy");
    iconMap.put(600, "fa-cloud-rain");
    iconMap.put(700, "fa-snowflake");
    iconMap.put(800, "fa-cloud-bolt");

    String icon = iconMap.getOrDefault(code, "Unknown");
    return icon;
  }

  //returns appropriate wind compass icon for a given wind direction
  public static String selectIconForWindDirection(String direction) {
    HashMap<String, String> iconMap = new HashMap<>();
    iconMap.put("N", "wi-towards-n");
    iconMap.put("NNE", "wi-towards-nne");
    iconMap.put("NE", "wi-towards-ne");
    iconMap.put("ENE", "wi-towards-ene");
    iconMap.put("E", "wi-towards-e");
    iconMap.put("ESE", "wi-towards-ese");
    iconMap.put("SE", "wi-towards-se");
    iconMap.put("SSE", "wi-towards-sse");
    iconMap.put("S", "wi-towards-s");
    iconMap.put("SSW", "wi-towards-ssw");
    iconMap.put("SW", "wi-towards-sw");
    iconMap.put("WSW", "wi-towards-wsw");
    iconMap.put("W", "wi-towards-w");
    iconMap.put("WNW", "wi-towards-wnw");
    iconMap.put("NW", "wi-towards-wi-towards-nw");
    iconMap.put("NNW", "wi-towards-nnw");

    String icon = iconMap.getOrDefault(direction, "Unknown");
    return icon;
  }

  //returns the appropriate thermometer icon for a given temperature
  public static String selectIconForTemperature(float temperature) {
    if (temperature < 0) {
      return "fa-temperature-empty";
    } else if (temperature >= 0 && temperature <= 10) {
      return "fa-temperature-quarter";
    } else if (temperature >= 10 && temperature <= 20) {
      return "fa-temperature-half";
    } else if (temperature >= 20 && temperature <= 30) {
      return "fa-temperature-three-quarters";
    } else if (temperature >= 30 && temperature <= 40) {
      return "fa-temperature-full";
    } else {
      return "fa-temperature-three-quarters"; // Default
    }
  }

  public static String selectPressureArrowTrendIcon(List<Reading> readings) {
    boolean descending = StationAnalytics.checkPressureDescending(readings);
    boolean ascending = StationAnalytics.checkPressureAscending(readings);

    if (descending) {
      return "fa-solid fa-arrow-down";
    } else if (ascending) {
      return "fa-solid fa-arrow-up";
    }
    return "";
  }

  public static String selectTemperatureArrowTrendIcon(List<Reading> readings) {
    boolean descending = StationAnalytics.checkTemperatureDescending(readings);
    boolean ascending = StationAnalytics.checkTemperatureAscending(readings);

    if (descending) {
      return "fa-solid fa-arrow-down";
    } else if (ascending) {
      return "fa-solid fa-arrow-up";
    }
    return "";
  }

  public static String selectWindArrowTrend(List<Reading> readings) {
    boolean descending = StationAnalytics.checkWindDescending(readings);
    boolean ascending = StationAnalytics.checkWindAscending(readings);

    if (descending) {
      return "fa-solid fa-arrow-down";
    } else if (ascending) {
      return "fa-solid fa-arrow-up";
    }
    return "";
  }

}
