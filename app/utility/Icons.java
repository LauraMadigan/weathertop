package utility;

import java.util.HashMap;

public class Icons {
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
}
