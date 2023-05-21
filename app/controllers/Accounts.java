package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class Accounts extends Controller {
  public static void signup() {
    render("signup.html");
  }

  public static void login() {
    render("login.html");
  }

  public static void register(String firstname, String lastname, String email, String password) {
    Logger.info("Registering new user " + email);
    Member member = new Member(firstname, lastname, email, password); //create a new member object from the passed in data
    member.save();                                                    //save them in the database
    redirect("/login");                                           //redirect to login page
  }

  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);
    Member member = Member.findByEmail(email);  //finds a member by their email address
    if ((member != null) && (member.checkPassword(password) == true)) {   //if there's a member and the password matches
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);   //put that member id into the session
      redirect("/dashboard");                    //redirect them to the dashboard
    } else {
      Logger.info("Authentication failed");   //otherwise redirect them to the login page
      redirect("/login");
    }
  }

  public static void logout() {
    session.clear();        //clears the session
    redirect("/");     //redirects to homepage
  }

  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {   //look inside session object to see if a member is logged in
      String memberId = session.get("logged_in_Memberid");  //and if there is a member id
      member = Member.findById(Long.parseLong(memberId));   //use that id to look them up in the database
    } else {
      login();                                              //otherwise, show the login page
    }
    return member;                                          //return the member object
  }

  //gets the profile of the current logged in member
  //and renders the profile view with this member
  public static void getProfile() {
    Logger.info("Rendering profile");
    Member member = getLoggedInMember();
    render("profile.html", member);
  }

  public static void deleteProfile() {
    Logger.info("Deleting profile");
    Member member = getLoggedInMember();          //get the logged in member
    session.clear();                              //clear their session
    member.delete();                              //delete the member
    redirect("/");                            //redirect to homepage
  }

  //  updates member details by reassigning the values that the user inputs
//  to that member's fields, and then saves the updated model
  public static void updateDetails(String firstname, String lastname, String email, String password) {
    Member member = getLoggedInMember();
    member.firstname = firstname;
    member.lastname = lastname;
    member.email = email;
    member.password = password;
    Logger.info("Updating User Details" + firstname + lastname + email);
    member.save();
    redirect("/profile");
  }
}