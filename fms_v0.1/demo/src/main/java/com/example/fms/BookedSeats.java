package com.example.fms;
import java.util.ArrayList;

public class BookedSeats {
    private String BookedSeatsString;
    public BookedSeats(String ss)
    {
        this.BookedSeatsString = ss;
    }
    public BookedSeats()
    {
        this.BookedSeatsString="";
    }
    public String getBookedSeatsString() {
        return BookedSeatsString;
    }
    public void setBookedSeatsString(String bookedSeatsString) {
        BookedSeatsString = bookedSeatsString;
    }
    public void convertstring(ArrayList<AvailSeats> arlist)
    {
        for( AvailSeats obj : arlist)
        {
            BookedSeatsString=BookedSeatsString+" "+ obj.getSeat();
        }
    }
}
