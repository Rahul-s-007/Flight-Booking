package com.example.fms;

public class AvailFlight
{
    private String Flightnums;
    private String DepartureTime;
    private String ArrivalTime;
    private String EconomyPrice;
    private String BusinessPrice;
        public AvailFlight(String Flightnums,String DepartureTime,String ArrivalTime,String EconomyPrice,String BusinessPrice)
        {
            this.Flightnums=Flightnums;
            this.DepartureTime=DepartureTime;
            this.ArrivalTime=ArrivalTime;
            this.EconomyPrice=EconomyPrice;
            this.BusinessPrice=BusinessPrice;

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
        public void setBusinessPrice(String businessPrice)
        {
            BusinessPrice = businessPrice;
        }
        public String getBusinessPrice()
        {
            return BusinessPrice;
        }
        public void setDepartureTime(String departureTime)
        {
            DepartureTime = departureTime;
        }
        public String getDepartureTime()
        {
            return DepartureTime;
        }
        public void setEconomyPrice(String economyPrice)
        {
            EconomyPrice = economyPrice;
        }
        public String getEconomyPrice() {
            return EconomyPrice;
        }
}