package controllers;

import java.util.*;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    Logger.info ("Member:" + member.email);
    List<Station> stations = member.station;
    Collections.sort(stations, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    render ("dashboard.html", member, stations);
  }

  public static void addStation (String name, float latitude, float longitude) {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    member.station.add(station);
    member.save();
    Logger.info ("Adding a new weather station called " + name);
    station.save();
    redirect ("/dashboard");
  }

  public static void deleteStation (Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Removing" + station);
    Member member = Accounts.getLoggedInMember();
    member.station.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }
}

