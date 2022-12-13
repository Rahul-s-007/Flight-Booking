package com.example.fms;

public class BookedFlight {
    private String From;
    private String To;
    private String Passengers;
    private String ArrivalTime;
    private String DepartureTime;
    private String Date;
    public BookedFlight(String From, String To, String Passengers, String ArrivalTime, String DepartureTime, String Date)
    {
        this.ArrivalTime = ArrivalTime;
        this.DepartureTime = DepartureTime;
        this.From = From;
        this.To = To;
        this.Date = Date;
        this.Passengers = Passengers;
    }
    public String getArrivalTime() {
        return ArrivalTime;
    }
    public String getDate() {
        return Date;
    }
    public String getDepartureTime() {
        return DepartureTime;
    }
    public String getFrom() {
        return From;
    }
    public String getPassengers() {
        return Passengers;
    }
    public String getTo() {
        return To;
    }
    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }
    public void setDate(String date) {
        Date = date;
    }
    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }
    public void setFrom(String from) {
        From = from;
    }
    public void setPassengers(String passengers) {
        Passengers = passengers;
    }
    public void setTo(String to) {
        To = to;
    }
        
}
