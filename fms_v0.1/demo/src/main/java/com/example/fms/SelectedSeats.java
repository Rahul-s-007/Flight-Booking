package com.example.fms;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class SelectedSeats {
    private static ArrayList <String> SelectedSeats= new ArrayList<String>();
    private String Selstring;
    private int numofseats;
    public SelectedSeats(String Selstring)
    {
        this.Selstring = Selstring;
    }
    public SelectedSeats()
    {
        this.Selstring = "";
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
        System.out.println("Selected sets:"+Selstring);
        return SelectedSeats;
   }
   public void setNumofseats(int numofseats) {
       this.numofseats = numofseats;
   }
   public int getNumofseats() {
       return numofseats;
   }
}
