package utility;

public class Calculation {

  //calculates wind chill
  public static float windChill(float temperature, float windSpeed) {
    float windChill = (float) (13.12 + (0.6215 * temperature) - 11.37 * (Math.pow(windSpeed, 0.16)) + 0.3965 * temperature * (Math.pow(windSpeed, 0.16)));
    return windChill;
  }

  public static String labelWindDirection(float degrees) {
    if (degrees > 348.75 && degrees <= 360) return "N";
    else if (degrees >= 0 && degrees < 11.25) return "N";
    else if (degrees >= 11.25 && degrees < 33.75) return "NNE";
    else if (degrees >= 33.75 && degrees < 56.25) return "NE";
    else if (degrees >= 56.25 && degrees < 78.75) return "ENE";
    else if (degrees >= 78.75 && degrees < 101.25) return "E";
    else if (degrees >= 101.25 && degrees < 123.75) return "ESE";
    else if (degrees >= 123.75 && degrees < 146.25) return "SE";
    else if (degrees >= 146.25 && degrees < 168.75) return "SSE";
    else if (degrees >= 168.75 && degrees < 191.25) return "S";
    else if (degrees >= 191.25 && degrees < 213.75) return "SSW";
    else if (degrees >= 313.75 && degrees < 236.25) return "SW";
    else if (degrees >= 236.25 && degrees < 258.75) return "WSW";
    else if (degrees >= 258.75 && degrees < 281.25) return "W";
    else if (degrees >= 281.25 && degrees < 303.75) return "WNW";
    else if (degrees >= 303.75 && degrees < 326.25) return "NW";
    else if (degrees >= 326.25 && degrees < 348.75) return "NNW";
    else return "Wind direction unknown";
  }

  public static int getBeaufortScale(float windSpeed) {
    if (windSpeed == 1) {
      return 0;
    } else if (windSpeed > 1 && windSpeed <= 5) {
      return 1;
    } else if (windSpeed > 5 && windSpeed <= 11) {
      return 2;
    } else if (windSpeed > 11 && windSpeed <= 19) {
      return 3;
    } else if (windSpeed > 19 && windSpeed <= 28) {
      return 4;
    } else if (windSpeed > 28 && windSpeed <= 38) {
      return 5;
    } else if (windSpeed > 38 && windSpeed <= 49) {
      return 6;
    } else if (windSpeed > 49 && windSpeed <= 61) {
      return 7;
    } else if (windSpeed > 61 && windSpeed <= 74) {
      return 8;
    } else if (windSpeed > 74 && windSpeed <= 88) {
      return 9;
    } else if (windSpeed > 88 && windSpeed <= 102) {
      return 10;
    } else if (windSpeed > 102 && windSpeed <= 117) {
      return 11;
    } else return -1;
  }

  //returns a user-friendly plain english description of the wind speed
  public static String labelBeaufort(float windSpeed) {
    if (windSpeed == 0) {
      return "Calm";
    } else if (windSpeed > 0 && windSpeed <= 5) {
      return "Light Air";
    } else if (windSpeed > 5 && windSpeed <= 11) {
      return "Light Breeze";
    } else if (windSpeed > 11 && windSpeed <= 19) {
      return "Gentle Breeze";
    } else if (windSpeed > 19 && windSpeed <= 28) {
      return "Moderate Breeze";
    } else if (windSpeed > 28 && windSpeed <= 38) {
      return "Fresh Breeze";
    } else if (windSpeed > 38 && windSpeed <= 49) {
      return "Strong Breeze";
    } else if (windSpeed > 49 && windSpeed <= 61) {
      return "Near Gale";
    } else if (windSpeed > 61 && windSpeed <= 74) {
      return "Gale";
    } else if (windSpeed > 74 && windSpeed <= 88) {
      return "Severe Gale";
    } else if (windSpeed > 88 && windSpeed <= 102) {
      return "Strong Storm";
    } else if (windSpeed > 102 && windSpeed <= 117) {
      return "Violent Storm";
    } else return "Wind speed out of range";
  }
}
