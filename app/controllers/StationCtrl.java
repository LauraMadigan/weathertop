package controllers;

import models.Reading;
import play.Logger;
import play.mvc.Controller;
import models.Station;

public class StationCtrl extends Controller {

  public static void index(Long id)
  {
    Logger.info("Rendering station" + id);
    Station station = Station.findById(id);
    render ("stationlayout.html", station);
  }

  public static void addReading(Long id, int code, float temperature, float windSpeed, float windDirection, int pressure) {
    Logger.info("Adding reading to station: " + id + code + temperature + windSpeed + windDirection+ pressure);
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/stations/"+id);
  }

  public static void deleteReading (Long id, Long readingid)
  {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info ("Removing" + reading);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    redirect("/stations/"+id);
  }

}
