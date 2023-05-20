package controllers;

import play.Logger;
import play.mvc.Controller;

public class Start extends Controller {
  public static void index() {                    //shows the starting welcome page
    Logger.info("Rendering Start");
    render("start.html");
  }
}
