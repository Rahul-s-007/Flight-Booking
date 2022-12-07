package com.example.fms;
import java.util.ArrayList;
public class SelectedSeats {
    private ArrayList <String> SelectedSeats= new ArrayList<String>();
    public SelectedSeats(ArrayList<String> ss)
    {
        SelectedSeats  = ss;
    }
    public SelectedSeats()
    {
        
    }
    public void setSelectedSeats(ArrayList<String> selectedSeats) {
        SelectedSeats = selectedSeats;
    }
    public ArrayList<String> getSelectedSeats() {
        return SelectedSeats;
    }
}
