package com.example.fms;
import java.sql.Date;

public class FlightInfoUser {
    private String from;
    private String to;
    private Date date;
    private int passengers;
    public void setFrom(String from)
    {
        this.from=from;
    }
    public void setTo(String to)
    {
        this.to=to;
    }
    public void setDate(Date date)
    {
        this.date=date;
    }
    public void setPassengers(int passengers)
    {
        this.passengers=passengers;
    }
    public String getFrom()
    {
        return from;
    }
    public String getTo()
    {
        return to;
    }
    public Date getDate()
    {
        return date;
    }
    public int getPassengers()
    {
        return passengers;
    }
}

