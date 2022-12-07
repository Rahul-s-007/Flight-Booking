package com.example.fms;

public class AvailSeats {
    private String Seat;
    public AvailSeats(String Seat)
    {
        this.Seat=Seat;
    }
    public String getSeat()
    {
        return Seat;
    }
    public void setSeat(String seat) {
        Seat = seat;
    }
}