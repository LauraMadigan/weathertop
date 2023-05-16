package utility;

public class Icons {
  public static String selectIconForConditions(int code) {
    String icon;
    switch (code) {
      case 100:
        icon = "fa-sun"; // Clear
        break;
      case 200:
        icon = "fa-cloud-sun"; // Partial Clouds
        break;
      case 300:
        icon = "fa-cloud"; // Cloudy
        break;
      case 400:
        icon = "fa-cloud-sun-rain"; // Showers
        break;
      case 500:
        icon = "fa-cloud-showers-heavy"; // Heavy Showers
        break;
      case 600:
        icon = "fa-cloud-rain"; // Rain
        break;
      case 700:
        icon = "fa-snowflake"; // Snow
        break;
      case 800:
        icon = "fa-cloud-bolt"; // Thunder
        break;
      default:
        icon = "Unknown"; // Unknown
    }
    return icon;
  }
}
