package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {
    @GetMapping("/FlightInfo")
    public String StartFlightInfo(Model model) {
        FlightInfoUser user = new FlightInfoUser();
         model.addAttribute("user", user);
         
        return "FlightInfoUser";
    }
    @PostMapping(path="/FlightInfo")
    public String EndFlightInfo(@ModelAttribute("user") FlightInfoUser user) {
        return "ShowAvailableFlight";
    }
}