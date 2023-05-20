package controllers;

import java.util.*;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {

  public static void index()  //lists member's stations on their dashboard
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();                                   //find the logged in member
    Logger.info("Member:" + member.email);
    List<Station> stations = member.station;                                        //get that member's stations
    Collections.sort(stations, (o1, o2) -> o1.getName().compareTo(o2.getName()));   //sort them alphabetically
    render("dashboard.html", member, stations);                             //render that member's stations on the dashboard
  }

  public static void addStation(String name, float latitude, float longitude) {
    Member member = Accounts.getLoggedInMember();                                   //find logged in member
    Station station = new Station(name, latitude, longitude);                       //create new station object
    member.station.add(station);                                                    //add it to that member's station collection
    member.save();                                                                  //updates the member
    Logger.info("Adding a new weather station called " + name);
    station.save();                                                                 //saves the new station
    redirect("/dashboard");
  }

  public static void deleteStation(Long id) {
    Station station = Station.findById(id);                                         //find the station by its id
    Logger.info("Removing" + station);
    Member member = Accounts.getLoggedInMember();                                   //look up the logged in member
    member.station.remove(station);                                                 //remove this station from their stations collection
    member.save();                                                                  //update the member
    station.delete();                                                               //delete the station
    redirect("/dashboard");                                                    //redirect to their dashboard
  }
}

