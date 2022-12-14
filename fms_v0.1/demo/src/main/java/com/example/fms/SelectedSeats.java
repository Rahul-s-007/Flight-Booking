package com.example.fms;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class SelectedSeats {
    private static ArrayList <String> SelectedSeats= new ArrayList<String>();
    private String Selstring;
    private int numofseats=0;
    public SelectedSeats(String Selstring)
    {
        this.Selstring = Selstring;
    }
    public SelectedSeats()
    {
        
    }
   public String getSelstring() {
       return Selstring;
   }
   public void setSelstring(String Selstring) {
       this.Selstring = Selstring;
   }
   public ArrayList<String> convertseats()
   {
        StringTokenizer str = new StringTokenizer(Selstring, " ");
        while(str.hasMoreTokens())
        {
            SelectedSeats.add(str.nextToken().toLowerCase().trim());
        }
        numofseats=SelectedSeats.size();
        return SelectedSeats;
   }
   public void setNumofseats(int numofseats) {
       this.numofseats = numofseats;
   }
   public int getNumofseats() {
       return numofseats;
   }
}
