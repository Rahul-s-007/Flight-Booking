package com.example.fms;

public class BookedFlight {
    private String From;
    private String To;
    private String FlightNum;
    private String ArrivalTime;
    private String DepartureTime;
    //public BookedFlight(String From, String To, String ArrivalTime, String DepartureTime, String FlightNum)
    public BookedFlight(String FlightNum, String From, String To, String ArrivalTime, String DepartureTime)
    {
        this.ArrivalTime = ArrivalTime;
        this.DepartureTime = DepartureTime;
        this.From = From;
        this.To = To;
        this.FlightNum = FlightNum;
    }
    public String getArrivalTime() {
        return ArrivalTime;
    }
    public String getFlightNum() {
        return FlightNum;
    }
    public String getDepartureTime() {
        return DepartureTime;
    }
    public String getFrom() {
        return From;
    }
    public String getTo() {
        return To;
    }
    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }
    public void setFlightNum(String flightNum) {
        FlightNum = flightNum;
    }
    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }
    public void setFrom(String from) {
        From = from;
    }
    public void setTo(String to) {
        To = to;
    }
        
}
