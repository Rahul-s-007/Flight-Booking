package com.example.fms;
import java.util.ArrayList;

public class summary {
    private static ArrayList <String> SelectedSeats= new ArrayList<String>();
    private int totalprice;
    private String to;
    private String from;
    private String date;
    public summary(ArrayList<String> ss,int totalprice,String to,String from,String date)
    {
        SelectedSeats=ss;
        this.totalprice=totalprice;
        this.to=to;
        this.from=from;
        this.date=date;
    }
    public summary()
    {
        
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public static void setSelectedSeats(ArrayList<String> selectedSeats) {
        SelectedSeats = selectedSeats;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public String getDate() {
        return date;
    }
    public String getFrom() {
        return from;
    }
    public static ArrayList<String> getSelectedSeats() {
        return SelectedSeats;
    }
    public String getTo() {
        return to;
    }
    public int getTotalprice() {
        return totalprice;
    }
}
