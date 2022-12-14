// http://localhost:4000/

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
   private static ArrayList<AvailSeats> AvailSeats = new ArrayList<AvailSeats>();
   private static ArrayList<BookedFlight> userbookedflights = new ArrayList<BookedFlight>();
   private static ArrayList<String> seatsselec = new ArrayList<String>();
   // adding objects for call the queries and manage controller
    testdb query = new testdb();
    LoginUser manage = new LoginUser();
    FromTo fromto = new FromTo();
    SelectedSeats selseat = new SelectedSeats();
    ShowAvailFlights flightno = new ShowAvailFlights();
    FlightInfoUser fiu = new FlightInfoUser();
    String dateselected;
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
        manage=loginuser;
        String check = query.checkLogin(loginuser);
        if(check.equals("Successful"))
        response.sendRedirect("/FlightInfo");
        else
        response.sendRedirect("/errorpage");
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
        String check = query.registerUser(newuser);
        if(check.equals("User successfully added"))
        {
            response.sendRedirect("/FlightInfo");
            LoginUser temp=new LoginUser(newuser.getUsername(),newuser.getPassword());
            manage=temp;
        }
        else
        response.sendRedirect("/errorpage");
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
        dateselected=Flightinfo.getDateString();
        avf=query.getAvailableFlights(Flightinfo);
        fromto.setFrom(Flightinfo.getFrom());
        fromto.setTo(Flightinfo.getTo());
        System.out.println("Number of seats seleced"+Flightinfo.getPassString());
        //redirecting to the next page after getting the info from html
        response.sendRedirect("/ShowAvailableFlight");
    }
    @GetMapping("/ShowAvailableFlight")
    public String StartShowFlights(Model model)
    {
        //creating objects of the ShowAvailFlight and add it to html to get input 
        ShowAvailFlights FlightNoSelected= new ShowAvailFlights();
        model.addAttribute("fromto", fromto);
        model.addAttribute("FlightNo", FlightNoSelected);
        //adding avf for the html to get the available flights
        model.addAttribute("avf", avf);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "ShowAvailableFlight";
    }
    @PostMapping("/ShowAvailableFlight")
    public @ResponseBody void EndShowFlights(@ModelAttribute("FlightNo") ShowAvailFlights FlightNoSelected,Model model,HttpServletResponse response,@RequestParam("flightnumberbtn")String Flightnum)throws IOException
    {
        AvailSeats=query.availableSeats(Flightnum);
        
        System.out.println(AvailSeats);
        flightno.setFlightNo(Flightnum);
        //redirecting to the next page after getting the info from html
        response.sendRedirect("/AvailableSeats");
    }
    @GetMapping("/AvailableSeats")
    public String StartAvailableSeats(Model model)
    {
        //creating objects of the SelectedSeats and add it to html to get input
       SelectedSeats ss = new SelectedSeats();
       ss.setSelstring("");
       BookedSeats bs = new BookedSeats();
       bs.convertstring(AvailSeats);
       System.out.println("Booked seatsstring"+bs.getBookedSeatsString());
       model.addAttribute("SelectedSeats", ss);
       model.addAttribute("BookedSeats", bs);
       model.addAttribute("bookseatstring", bs.getBookedSeatsString());
       //adding FilledSeats for the html to get the seats alreay filled
        model.addAttribute("AvailSeats", AvailSeats);
        //the return statement call the html file to run(return statement and the html file name should be same)
        return "AvailableSeats";
    }
    @PostMapping("/AvailableSeats")
    public @ResponseBody void EndAvailableSeats(@ModelAttribute("SelectedSeats") SelectedSeats ssobj, Model model,HttpServletResponse response)throws IOException
    {
        //Add selected seats to db
        selseat = ssobj;
        System.out.println("selstring: "+ssobj.getSelstring());//error over here
        seatsselec.clear();
        seatsselec=selseat.convertseats();
        response.sendRedirect("/ShowingTheFinalSummary");
    }
    @GetMapping("/ShowingTheFinalSummary")
    public String StartSummary(Model model)
    {
        // for testing
        // ArrayList<String> seatest = new ArrayList<String>();
        // seatest.add("a1");
        // seatest.add("a2");
        // seatest.add("b1");
        // seatest.add("b2");
        // summary sum = new summary(seatest, 1000, "dubai", "mumbai", "2023-02-07");
        int tp= selseat.getNumofseats()*query.getSeatPrice(flightno.getFlightNo());
        // System.out.println(selseat.getNumofseats());
        summary sum=new summary(seatsselec,tp,fromto.getTo(),fromto.getFrom(),dateselected);
        model.addAttribute("Summary",sum);
        //pass booked seat to db
        query.arraySeatsBooked(flightno.getFlightNo(), seatsselec, manage.getUsername());
        return "Summary";
    }
    @PostMapping("/ShowingTheFinalSummary")
    public @ResponseBody void EndSummary(HttpServletResponse response)throws IOException
    {
        query.arraySeatsBooked(flightno.getFlightNo(),seatsselec,manage.getUsername());
        response.sendRedirect("/FlightInfo");
    }
    @GetMapping("/Manage")
    public String StartManage(Model model)
    {
        userbookedflights=query.userBookedFlights(manage.getUsername());
        model.addAttribute("BookedFlights", userbookedflights);
        return "manage";
    }
    @PostMapping("/Manage")
    public void EndManage(ShowAvailFlights flightnum,HttpServletResponse response, @RequestParam("cancelbtn")String Flightnum)throws IOException
    {
        query.arraySeatsRemove(Flightnum,manage.getUsername());
        response.sendRedirect("/FlightInfo");
    }
}