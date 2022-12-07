package com.example.fms;
import org.springframework.ui.Model;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {
    
   private static ArrayList<AvailFlight> avf = new ArrayList<AvailFlight>();
   private static ArrayList<AvailSeats> FilledSeats=new ArrayList<AvailSeats>();
    @GetMapping("/FlightInfo")
    public String StartFlightInfo(Model model) {
        FlightInfoUser Flightinfo = new FlightInfoUser();
        model.addAttribute("Flightinfo", Flightinfo);
        return "FlightInfoUser";
    }
    @PostMapping(path="/FlightInfo")
    public String EndFlightInfo(@ModelAttribute("Flightinfo") FlightInfoUser Flightinfo, Model model) {
        // ShowAvailFlights FlightNoSelected = new ShowAvailFlights();
        // model.addAttribute("FlightNoSelected", FlightNoSelected);
        ArrayList<String> FlightNo=new ArrayList<String>();
        ArrayList<String> Departure=new ArrayList<String>();
        ArrayList<String> Arrival=new ArrayList<String>();
        // ArrayList<Integer> Economy=new ArrayList<Integer>();
        // ArrayList<Integer> Business=new ArrayList<Integer>();

        // ArrayList<Date> flightDate=new ArrayList<Date>();

       
        FlightNo.add("EK069");
        FlightNo.add("EK420");
        FlightNo.add("EK123");
        Departure.add("Dubai");
        Departure.add("Dubai");
        Departure.add("Dubai");
        Arrival.add("Mumbai");
        Arrival.add("Mumbai");
        Arrival.add("Mumbai");
        Arrival.add("Mumbai");
        // flightDate.add(0,Date.valueOf("2023-01-07"));
        // flightDate.add(1,Date.valueOf("2023-01-08"));
        // flightDate.add(2,Date.valueOf("2023-01-09"));


        // avf.add(new AvailFlight("EK069", "mumbai", "Dubai"));
        // avf.add(new AvailFlight("EK420", "mumbai", "Dubai"));
        // avf.add(new AvailFlight("EK101", "mumbai", "Dubai"));
        //setting all attributes
        //here we call the query for the flight available 
        // model.addAttribute("FlightNo", FlightNo);
        // model.addAttribute("Departure", Departure);
        // model.addAttribute("Arrival", Arrival);
        // model.addAttribute("Economy", Economy);
        // model.addAttribute("Business", Business);
        // model.addAttribute("flightDate",flightDate);
        // model.addAttribute("avf", avf);
        return "ShowAvailableFlight";
    }
    @GetMapping("/ShowAvailableFlight")
    public String StartShowFlights(Model model)
    {
        ShowAvailFlights FlightNoSelected= new ShowAvailFlights();
        model.addAttribute("FlightNo", FlightNoSelected);
        avf.add(new AvailFlight("EK069", "mumbai", "Dubai"));
        avf.add(new AvailFlight("EK420", "mumbai", "Dubai"));
        avf.add(new AvailFlight("EK101", "mumbai", "Dubai"));
        model.addAttribute("avf", avf);
        return "ShowAvailableFlight";
    }
    @PostMapping("/ShowAvailableFlight")
    public String EndShowFlights(@ModelAttribute("FlightNo") ShowAvailFlights FlightNoSelected,Model model)
    {
       
        // ArrayList<AvailSeats> FilledSeats=new ArrayList<AvailSeats>();
        // FilledSeats.add(new AvailSeats("A2"));
        // FilledSeats.add(new AvailSeats("A3"));
        // FilledSeats.add(new AvailSeats("A4"));
        // FilledSeats.add(new AvailSeats("A5"));
        // FilledSeats.add(new AvailSeats("A6"));
        // model.addAttribute("FilledSeats", FilledSeats);
        
        return "AvailableSeats";
    }
    @GetMapping("/AvailableSeats")
    public String StartAvailableSeats(Model model)
    {
       SelectedSeats ss = new SelectedSeats();
       model.addAttribute("SelectedSeats", ss);
        FilledSeats.add(new AvailSeats("A2"));
        FilledSeats.add(new AvailSeats("A3"));
        FilledSeats.add(new AvailSeats("A4"));
        FilledSeats.add(new AvailSeats("A5"));
        FilledSeats.add(new AvailSeats("A6"));
        model.addAttribute("FilledSeats", FilledSeats);
        return "AvailableSeats";
    }
    @PostMapping("/AvailableSeats")
    public String EndAvailableSeats(@ModelAttribute("SelectedSeats") SelectedSeats ss, Model model)
    {
        //Add selected seats to db
        return "P";
    }
}