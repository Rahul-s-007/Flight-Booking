package com.example.fms;
import java.sql.Date;

public class AvailFlight
{
    private String Flightnums;
    private String From;
    private String To;
    private Date FlightDate;

        public AvailFlight(String Flightnums,String From,String To,Date date)
        {
            this.Flightnums=Flightnums;
            this.From=From;
            this.To=To;
            this.FlightDate=date;

        }
        public AvailFlight(String Flightnums,String From,String To)
        {
            this.Flightnums=Flightnums;
            this.From=From;
            this.To=To;

        }
        public AvailFlight()
        {
            
        }
        public String getFlightnums()
        {
            return this.Flightnums;
        }
        public String getFrom()
        {
            return this.From;
        }
        public String getTo()
        {
            return this.To;
        }
        public Date getdate()
        {
            return this.FlightDate;
        }
        public void setTo(String to) {
            To = to;
        }
        public void setdate(Date date) {
            this.FlightDate = date;
        }
        public void setFlightnums(String flightnums) {
            Flightnums = flightnums;
        }
        public void setFrom(String from) {
            From = from;
        }  
    
}