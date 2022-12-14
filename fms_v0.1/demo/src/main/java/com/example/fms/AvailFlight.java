package com.example.fms;

public class AvailFlight
{
    private String Flightnums;
    private String DepartureTime;
    private String ArrivalTime;
    private String Price;

        public AvailFlight(String Flightnums,String DepartureTime,String ArrivalTime,String Price)
        {
            this.Flightnums=Flightnums;
            this.DepartureTime=DepartureTime;
            this.ArrivalTime=ArrivalTime;
            this.Price=Price;

        }
        public AvailFlight()
        {
            
        }
        public String getFlightnums()
        {
            return this.Flightnums;
        }
        public void setFlightnums(String flightnums) {
            Flightnums = flightnums;
        }
        public String getArrivalTime()
        {
            return ArrivalTime;
        }
        public void setArrivalTime(String arrivalTime)
        {
            ArrivalTime = arrivalTime;
        }
        public void setDepartureTime(String departureTime)
        {
            DepartureTime = departureTime;
        }
        public String getDepartureTime()
        {
            return DepartureTime;
        }
        public void setPrice(String price)
        {
            Price = price;
        }
        public String getPrice() {
            return "AED "+Price;
        }
        public int getprice()
        {
            return (Integer.valueOf(Price));
        }
}
