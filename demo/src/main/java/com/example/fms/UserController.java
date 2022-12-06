package com.example.fms;
import org.springframework.ui.Model;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {
    @GetMapping("/FlightInfo")
    public String StartFlightInfo(Model model) {
        FlightInfoUser Flightinfo = new FlightInfoUser();
        model.addAttribute("Flightinfo", Flightinfo);
        return "FlightInfo";
    }
    @PostMapping(path="/FlightInfo")
    public String EndFlightInfo(@ModelAttribute("Flightinfo") FlightInfoUser Flightinfo) {
        return "ShowAvailableFlight";
    }
    @GetMapping("/ShowAvailableFlight")
    public String StartShowFlights(Model model)
    {
        ShowAvailFlights FlightNoSelected = new ShowAvailFlights();
        model.addAttribute("FlightNoSelected", FlightNoSelected);
        ArrayList<String> FlightNo=new ArrayList<String>();
        ArrayList<String> Departure=new ArrayList<String>();
        ArrayList<String> Arrival=new ArrayList<String>();
        ArrayList<Integer> Economy=new ArrayList<Integer>();
        ArrayList<Integer> Business=new ArrayList<Integer>();
        //here we call the query for the flight available 
        model.addAttribute("FlightNo", FlightNo);
        model.addAttribute("Departure", Departure);
        model.addAttribute("Arrival", Arrival);
        model.addAttribute("Economy", Economy);
        model.addAttribute("Business", Business);
        return "ShowAvailableFlight";
    }
    @PostMapping("/ShowAvailableFlight")
    public String EndShowFlights(@ModelAttribute("FlightNo") ShowAvailFlights FlightNoSelected)
    {
        return "AvailableSeats";
    }
    @GetMapping("/AvailableSeats")
    public String StartAvailableSeats(Model model)
    {
        ArrayList<String> FilledSeats=new ArrayList<String>();
        model.addAttribute("FilledSeats", FilledSeats);
        return "AvailableSeats";
    }
}