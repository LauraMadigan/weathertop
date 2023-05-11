package controllers;

import java.util.List;

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
    List<Station> stations = member.station;
    render ("dashboard.html", member, stations);
  }

  public static void addStation (String name) {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name);
    member.station.add(station);
    member.save();
    Logger.info ("Adding a new weather station called " + name);
    station.save();
    redirect ("/dashboard");
  }
}

