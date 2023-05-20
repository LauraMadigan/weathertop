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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");   //creates a formatter for date-times
    this.timeStamp = formatter.format(LocalDateTime.now());                             //creates a mew timestamp with the current date-time when a new reading is created
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

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

  //converts temperature from degrees celsius to degrees fahrenheit
  public float convertToFahrenheit() {
    return this.temperature * 9 / 5 + 32;
  }

  //Method to return user-friendly String description of weather conditions, from weather codes
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
    //return a description for a code, if code is unknown, default to return unknown description
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
    String windDirectionLabel = Calculation.labelWindDirection(this.getWindDirection());  //returns string direction
    return Icons.selectIconForWindDirection(windDirectionLabel);                          //looks up the icon for that direction
  }

  public int getBeaufortScale(float windSpeed) {
    return Calculation.getBeaufortScale(this.windSpeed);
  }

  public String labelBeaufort() {                         //find the plain English description of the wind
    return Calculation.labelBeaufort(this.windSpeed);
  }

}