package com.example.fms;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
@Controller
public class UserController {
    //initializing ArrayList avf(available flight)& filled seats(the seats already filled in the plane)
   private static ArrayList<AvailFlight> avf = new ArrayList<AvailFlight>();
   private static ArrayList<AvailSeats> FilledSeats=new ArrayList<AvailSeats>();

   @GetMapping("/")
   public String StartUserLogin(Model model){
    //creating objects of the LoginUser and add it to html to get input 
    LoginUser loginuser = new LoginUser();
        model.addAttribute("loginuser", loginuser);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "index";
   }
   @PostMapping("/")
   public  @ResponseBody void EndUserLogin(@ModelAttribute("loginuser") LoginUser loginuser, Model model,HttpServletResponse response) throws IOException{
        //call the query to check wether the username and password is correct if not redirect to error page
        //redirecting to the next page after getting the info from html
        response.sendRedirect("/FlightInfo");
   }
   @GetMapping("/NewUser")
   public String StartNewUser(Model model){
    //creating objects of the LoginUser and add it to html to get input 
    NewUser newuser = new NewUser();
        model.addAttribute("newuser", newuser);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "new_user";
   }
   @PostMapping("/NewUser")
   public  @ResponseBody void EndNewUser(@ModelAttribute("newuser") NewUser newuser, Model model,HttpServletResponse response) throws IOException{
        //call a query to add the new username and password
        //redirecting to the next page after getting the info from html
        response.sendRedirect("/FlightInfo");
   }
    @GetMapping("/FlightInfo")
    public String StartFlightInfo(Model model) {
        //creating objects of the flightinfoUser and add it to html to get input 
        FlightInfoUser Flightinfo = new FlightInfoUser();
        model.addAttribute("Flightinfo", Flightinfo);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "FlightInfoUser";
    }
    @PostMapping(path="/FlightInfo")
    public @ResponseBody void EndFlightInfo(@ModelAttribute("Flightinfo") FlightInfoUser Flightinfo, Model model,HttpServletResponse response)throws IOException {
        //call query to get AvailFlights
        //redirecting to the next page after getting the info from html
        response.sendRedirect("/ShowAvailableFlight");
    }
    @GetMapping("/ShowAvailableFlight")
    public String StartShowFlights(Model model)
    {
        // adding the available flight(thier flight no,time of departur and time of arrival) to avf(for testing adding like else we will call a function to carry out the query)
        avf.add(new AvailFlight("EK069", "15:00", "17:00","12,000","40,000"));
        avf.add(new AvailFlight("EK069", "15:00", "17:00","12,000","40,000"));
        avf.add(new AvailFlight("EK069", "15:00", "17:00","12,000","40,000"));
        //creating objects of the ShowAvailFlight and add it to html to get input 
        ShowAvailFlights FlightNoSelected= new ShowAvailFlights();
        model.addAttribute("FlightNo", FlightNoSelected);
        //adding avf for the html to get the available flights
        model.addAttribute("avf", avf);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "ShowAvailableFlight";
    }
    @PostMapping("/ShowAvailableFlight")
    public @ResponseBody void EndShowFlights(@ModelAttribute("FlightNo") ShowAvailFlights FlightNoSelected,Model model,HttpServletResponse response)throws IOException
    {
        //call query to get filled seats 
        //redirecting to the next page after getting the info from html
        response.sendRedirect("/AvailableSeats");
    }
    @GetMapping("/AvailableSeats")
    public String StartAvailableSeats(Model model)
    {
        // adding the seat that are filled(in form of String a Capital letter and a number next to it) to FilledSeats(for testing adding like else we will call a function to carry out the query)
        FilledSeats.add(new AvailSeats("A2"));
        FilledSeats.add(new AvailSeats("A3"));
        FilledSeats.add(new AvailSeats("A4"));
        FilledSeats.add(new AvailSeats("A5"));
        FilledSeats.add(new AvailSeats("A6"));
        //creating objects of the SelectedSeats and add it to html to get input
       SelectedSeats ss = new SelectedSeats();
       model.addAttribute("SelectedSeats", ss);
       //adding FilledSeats for the html to get the seats alreay filled
        model.addAttribute("FilledSeats", FilledSeats);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "AvailableSeats";
    }
    @PostMapping("/AvailableSeats")
    public @ResponseBody void EndAvailableSeats(@ModelAttribute("SelectedSeats") SelectedSeats ss, Model model,HttpServletResponse response)throws IOException
    {
        //Add selected seats to db
        response.sendRedirect("/ShowingTheFinalSummary");
    }
    @GetMapping("/ShowingTheFinalSummary")
    public String StartSummary(Model model)
    {
        //will add any attributes if needed
        return "Summary";
    }
    @PostMapping("/ShowingTheFinalSummary")
    public @ResponseBody void EndSummary(HttpServletResponse response)throws IOException
    {
        response.sendRedirect("/UserLogin");
    }
}