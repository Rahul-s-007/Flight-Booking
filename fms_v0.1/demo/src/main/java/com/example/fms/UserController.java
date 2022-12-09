package com.example.fms;
import org.springframework.ui.Model;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {
    //initializing ArrayList avf(available flight)& filled seats(the seats already filled in the plane)
   private static ArrayList<AvailFlight> avf = new ArrayList<AvailFlight>();
   private static ArrayList<AvailSeats> FilledSeats=new ArrayList<AvailSeats>();
   //making objects because Spring boot is mother fucking annoying 
   LoginUser lu = new LoginUser();
   FlightInfoUser fiu=new FlightInfoUser();
   ShowAvailFlights saf=new ShowAvailFlights();

   @GetMapping("/UserLogin")
   public String StartUserLogin(Model model){
    //creating objects of the LoginUser and add it to html to get input 
        LoginUser loginuser = new LoginUser();
        model.addAttribute("loginuser", loginuser);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "UserLogin";
   }
   @PostMapping("/UserLogin")
   public String EndUserLogin(@ModelAttribute("loginuser") LoginUser loginuser, Model model){
        lu = loginuser;
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "FlightInfoUser";
   }
    @GetMapping("/FlightInfo")
    public String StartFlightInfo(Model model) {
        //creating objects of the flightinfoUser and add it to html to get input 
        FlightInfoUser Flightinfo = new FlightInfoUser();
        model.addAttribute("Flightinfo", Flightinfo);
        model.addAttribute("loginuser", lu);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "FlightInfoUser";
    }
    @PostMapping(path="/FlightInfo")
    public String EndFlightInfo(@ModelAttribute("Flightinfo") FlightInfoUser Flightinfo, Model model) {
        fiu=Flightinfo;
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "ShowAvailableFlight";
    }
    @GetMapping("/ShowAvailableFlight")
    public String StartShowFlights(Model model)
    {
        //use fiu to call the query
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
    public String EndShowFlights(@ModelAttribute("FlightNo") ShowAvailFlights FlightNoSelected,Model model)
    {
        saf=FlightNoSelected;
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "AvailableSeats";
    }
    @GetMapping("/AvailableSeats")
    public String StartAvailableSeats(Model model)
    {
        //use saf to call the query
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
    public String EndAvailableSeats(@ModelAttribute("SelectedSeats") SelectedSeats ss, Model model)
    {
        //Add selected seats to db
        return "P";
    }
}