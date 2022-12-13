package com.example.fms;

public class BookedFlight {
    private String From;
    private String To;
    private String Date;
    private String ArrivalTime;
    private String DepartureTime;
    public BookedFlight(String From, String To, String ArrivalTime, String DepartureTime, String Date)
    {
        this.ArrivalTime = ArrivalTime;
        this.DepartureTime = DepartureTime;
        this.From = From;
        this.To = To;
        this.Date = Date;
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
    public void setTo(String to) {
        To = to;
    }
        
}
