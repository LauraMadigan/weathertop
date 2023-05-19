package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import utility.Calculation;
import utility.Icons;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Entity
public class Reading extends Model {

  public int code;

  public float temperature;
  public float windSpeed;
  public int pressure;
  public float windDirection;
  public String timeStamp;



  public Reading(int code, float temperature, float windSpeed, float windDirection, int pressure) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    this.timeStamp = formatter.format(LocalDateTime.now());
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }

  public String getTimeStamp() {return timeStamp;}

  public int getCode() {
    return code;
  }

  public float getTemperature() {
    return temperature;
  }

  public float getWindSpeed() {
    return windSpeed;
  }

  public int getPressure() {
    return pressure;
  }

  public float getWindDirection() {
    return windDirection;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public float convertToFahrenheit() {
    return this.temperature * 9 / 5 + 32;
  }

  public String describeConditions() {
    HashMap<Integer, String> conditionsHashMap = new HashMap<Integer, String>();
    conditionsHashMap.put(100, "Clear");
    conditionsHashMap.put(200, "Partial clouds");
    conditionsHashMap.put(300, "Cloudy");
    conditionsHashMap.put(400, "Light showers");
    conditionsHashMap.put(500, "Heavy showers");
    conditionsHashMap.put(600, "Rain");
    conditionsHashMap.put(700, "Snow");
    conditionsHashMap.put(800, "Thunder");

    String description = conditionsHashMap.getOrDefault(code, "Unknown");

    return description;
  }

  public String selectIconForConditions() {
    return Icons.selectIconForConditions(this.code);
  }

  public String selectIconForTemperature() {
    return Icons.selectIconForTemperature(this.temperature);
  }

  public String selectIconForWindDirection() {
    String windDirectionLabel = Calculation.labelWindDirection(this.getWindDirection());
    return Icons.selectIconForWindDirection(windDirectionLabel);
  }

  public int getBeaufortScale() {
    if (this.windSpeed == 1) {
      return 0;
    } else if (this.windSpeed > 1 && this.windSpeed <= 5) {
      return 1;
    } else if (this.windSpeed > 5 && this.windSpeed <= 11) {
      return 2;
    } else if (this.windSpeed > 11 && this.windSpeed <= 19) {
      return 3;
    } else if (this.windSpeed > 19 && this.windSpeed <= 28) {
      return 4;
    } else if (this.windSpeed > 28 && this.windSpeed <=38) {
        return 5;
    } else if (this.windSpeed > 38 && this.windSpeed <=49) {
        return 6;
    } else if (this.windSpeed > 49 && this.windSpeed <=61) {
        return 7;
    } else if (this.windSpeed > 61 && this.windSpeed <=74) {
        return 8;
    } else if (this.windSpeed > 74 && this.windSpeed <=88) {
        return 9;
    } else if (this.windSpeed > 88 && this.windSpeed <=102) {
        return 10;
    } else if (this.windSpeed > 102 && this.windSpeed <=117) {
        return 11;
    }   else return -1;

  }

    public String labelBeaufort() {
        if (this.windSpeed == 0) {
            return "Calm";
        } else if (this.windSpeed > 0 && this.windSpeed <= 5) {
            return "Light Air";
        } else if (this.windSpeed > 5 && this.windSpeed <= 11) {
            return "Light Breeze";
        } else if (this.windSpeed > 11 && this.windSpeed <= 19) {
            return "Gentle Breeze";
        } else if (this.windSpeed > 19 && this.windSpeed <= 28) {
            return "Moderate Breeze";
        } else if (this.windSpeed > 28 && this.windSpeed <=38) {
            return "Fresh Breeze";
        } else if (this.windSpeed > 38 && this.windSpeed <=49) {
            return "Strong Breeze";
        } else if (this.windSpeed > 49 && this.windSpeed <=61) {
            return "Near Gale";
        } else if (this.windSpeed > 61 && this.windSpeed <=74) {
            return "Gale";
        } else if (this.windSpeed > 74 && this.windSpeed <=88) {
            return "Severe Gale";
        } else if (this.windSpeed > 88 && this.windSpeed <=102) {
            return "Strong Storm";
        } else if (this.windSpeed > 102 && this.windSpeed <=117) {
            return "Violent Storm";
        }   else return "Wind speed out of range";
    }

}