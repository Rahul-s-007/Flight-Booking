package com.example.fms;

import java.util.*;
import java.util.Date;

import java.sql.*;

public class testdb
{
    public String ans="";
    private Connection con;
    private Statement st;
    private Statement st1;
    private ResultSet rs;
    private ResultSet rs1;

    //Constructor
    public testdb()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flightmanagment","root","7703");
            st=con.createStatement();
            st1=con.createStatement();
        }catch(ClassNotFoundException | SQLException ex)
        {
            //JOptionPane.showMessageDialog(null,"Error: "+ex);
            System.out.println("DB Connection Error");
        }
    }
    
    
    public int isExists(String qtemp)
    {
        String query = String.format("select exists(%s) as res",qtemp);
        // System.out.println(query);
        try
        {
            rs = st.executeQuery(query);
            rs.next();
            // System.out.println(rs.getInt("res"));
            if(rs.getInt("res") == 1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        catch(SQLException ex)
        {
            //JOptionPane.showMessageDialog(null,"Error:"+ex);
            System.out.println("DB Error (IS EXISTS)");
        }
        return 0;
    }
    
    
    public ArrayList<AvailFlight> getAvailableFlights(FlightInfoUser ob)//done
    {
        Date date = ob.getDate();
        String to = ob.getTo();
        String from = ob.getFrom();
        int passengers = ob.getPassengers();
        //select flightnum, TIME(flightDATE), TIME(arrivalDATE), price from allflightnum where destTO = "Pune" AND destFROM = "Dubai" AND DATE(flightDATE) = "2023-01-07" AND numAvailableSeats >= 5 ORDER BY price ASC;
        String query = String.format("select flightnum, TIME(flightDATE), TIME(arrivalDATE), price from allflightnum where destTO = \"%s\" AND destFROM = \"%s\" AND DATE(flightDATE) = \"%s\" AND numAvailableSeats >= %d ORDER BY price ASC",to,from,date,passengers);
        ArrayList<AvailFlight> al=new ArrayList<AvailFlight>();
        
        // add datetime depature and arrival for each flight 
        int recordavail = isExists(query);
        if(recordavail == 1)
        {
            try
            {
                rs = st.executeQuery(query);
                while(rs.next())
                {
                    AvailFlight obj=new AvailFlight(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    al.add(obj);
                    //ans += rs.getString(1)  +" "+ rs.getString(2) +" "+ rs.getString(3) +"\n";
                }
                return al;
            }
            catch(SQLException ex)
            {
                System.out.println("DB arr Error");
                //return ex.toString();
            }
        }
        else
        {
            System.out.println("No records Available");
            return al;
        }
        return al;
    }
    
    
    // Check if user login credentials are correct
    public String checkLogin(LoginUser ob)//done
    {
        String usr = ob.getUsername();
        String pass = ob.getPassword();
        
        String query = String.format("select * from userlogin where username = \"%s\" and passwd = \"%s\"",usr,pass);
        
        int recordavail = isExists(query);
        if(recordavail == 1)
        {
            return "Successful";
        }
        else
        {
            System.out.println("No records Available");
            return "Invalid username or incorrect password";
        }
    }
    
    // Register data of new user
    public String registerUser(NewUser ob)//done
    {
        String name = ob.getName();
        String usr = ob.getUsername();
        String pass = ob.getPassword();
        
        String query1 = String.format("Insert into userlogin values(\"%s\", \"%s\", \"%s\")",usr,pass,name);
        String query2 = String.format("Create table %s (FlightsBooked varchar(10), flightDate datetime)",usr);
        
        String qchk = String.format("select * from userlogin where username = \"%s\"",usr);
        int recordavail = isExists(qchk);
        if(recordavail == 1)
        {
            return "Username already exists";
        }
        else
        {
            try
            {
                st.executeUpdate(query1);
                st.executeUpdate(query2);
                return "User successfully added";
            }
            catch(SQLException ex)
            {
                System.out.println("DB Error");
                return "DB Error Create New User";
            }
        }
        //if(username exists then return username exists else register user)
    }
    
    
    
    public ArrayList<AvailSeats> availableSeats(String flightNO) // flightNO ob done
    {
        // flno = ob.flightnum;
        //select seatName from EK507 where seatTaken = 0;
        String query = String.format("select seatName from %s where seatTaken = 1",flightNO);
        ArrayList<AvailSeats> ans = new ArrayList<AvailSeats>();
        
        try
        {
            rs = st.executeQuery(query);
            while(rs.next())
            {
                AvailSeats obj=new AvailSeats(rs.getString(1));
                ans.add(obj);
            }
            return ans;
        }
        catch(SQLException ex)
        {
            System.out.println("DB Error Available Seats");
            return ans;
        }
    }
    
    // change Availseats here accordingly
    public ArrayList<BookedFlight> userBookedFlights(String username) // flightNO ob done
    {
        // usr = ob.Username
        // select now();
        ArrayList<BookedFlight> ans = new ArrayList<BookedFlight>();
        
        String query1 = "select current_date as cd";
        String currDATE="";
        try
        {
            rs = st.executeQuery(query1);
            rs.next();
            currDATE = rs.getString(1); 
            //currDATE = rs.getDate("cd").toString();
            //System.out.println(currDATE);
        }
        catch(SQLException ex)
        {
            System.out.println("DB Error current date");
        }
        
        String query2 = String.format("Select FlightsBooked as fb from %s where DATE(flightDate) > \"%s\"",username,currDATE);
        System.out.println(query2);
        
        int recordavail = isExists(query2);
        if(recordavail == 1)
        {
            try
            {
                rs = st.executeQuery(query2);
                while(rs.next())
                {
                    //System.out.println(rs.getString("fb"));
                    String query3 = String.format("Select destTO, destFROM, flightDATE, arrivalDATE from allflightnum where flightnum = \"%s\"",rs.getString(1));
                    //System.out.println(query3);
                    rs1 = st1.executeQuery(query3);
                    //System.out.println("Query executed");
                    rs1.next();
                    // flightno,to,from,depature,arrival
                    //System.out.println(rs1.getString(1) + rs1.getString(2) + rs1.getString(3) + rs1.getString(4));
                    BookedFlight obj = new BookedFlight(rs.getString("fb"),rs1.getString(2), rs1.getString(1), rs1.getString(3), rs1.getString(4));
                    ans.add(obj);
                    //ans1.add(rs.getString(1));
                }
                return ans;
            }
            catch(SQLException ex)
            {
                System.out.println("DB Error user booked flights");
                return ans;
            }
        }
        else
        {
            System.out.println("No flights booked by user");
            return ans;
        }
    }


    // get seat price of a flight
    public int getSeatPrice(String flightNo)
    {
        int ans = 0;
        String query = String.format("Select price as pr from allflightnum where flightnum = \"%s\"",flightNo);
        try
        {
            rs = st.executeQuery(query);
            rs.next();
            ans = rs.getInt("pr");
        }
        catch(SQLException ex)
        {
            System.out.println(query);
            System.out.println("DB Error get price");
            return ans;
        }
        //List<String> ans = new ArrayList<String>();
        // select ecoPrice from allflightnum where flightnum = <flightNo>;
        // economy = output;
        // buissness = output*1.5;
        return ans; // return [eco,biss]
    }
    
    // Update seats which were booked in DB
    public void addSeatBooked(String seat, String flightNO, String username)//done
    {
        // update ek507 set bookedBy = <username>, seatTaken = 1 where seatName = ;
        String query = String.format("Update %s SET bookedBy = \"%s\", seatTaken = 1 where seatName = \"%s\"",flightNO ,username ,seat);
        try 
        {
            st.executeUpdate(query);
        } 
        catch(SQLException e) 
        {
            System.out.println("DB Error add seat = 1");
        }
    }
    
    // calls above function for each seat in array list
    public void arraySeatsBooked(String flightNO, List<String> seats, String username)//done
    {
        Iterator<String> itr = seats.iterator();
        while(itr.hasNext())
        {
            addSeatBooked(itr.next(), flightNO, username);
        }
        updateAvailableSeats(flightNO);
        String flightDATE = getFlightDATE(flightNO);
        addUserFlights(username, flightNO, flightDATE);
    }

    public String getFlightDATE(String flightNO)
    {
        String ans = "";
        String query = String.format("Select flightDATE as fd from allflightnum where flightnum = \"%s\"",flightNO);
        try
        {
            rs = st.executeQuery(query);
            rs.next();
            ans = rs.getString("fd");
        }
        catch(SQLException ex)
        {
            System.out.println(query);
            System.out.println("DB Error get flight date");
            return ans;
        }
        return ans;
    }


    public void addUserFlights(String username, String flighNO, String FlightDate)
    {
        String query = String.format("Insert into %s values(\"%s\",\"%s\")",username,flighNO,FlightDate);
        try 
        {
            st.executeUpdate(query);
        } 
        catch(SQLException e) 
        {
            System.out.println("DB Error insert flight in user");
        }

    }
    
    
    // Update seats which were cancled in DB
    public void removeSeatBooked(String flightNO, String seat)//done
    {
        String query = String.format("Update %s SET bookedBy = Null, seatTaken = 0 where seatName = \"%s\"",flightNO ,seat);
        try 
        {
            st.executeUpdate(query);
        } 
        catch(SQLException e) 
        {
            System.out.println("DB Error remove seat");
        }
    }
    
    // pases all the seats booked by user to remove them
    public void arraySeatsRemove(String flightNO, String username)//done
    {
        // select seatName from pk505 where bookedBy = "rahuls";
        String query = String.format("Select seatName from %s where bookedBy = \"%s\"",flightNO,username);
        try
        {
            rs = st.executeQuery(query);
            while(rs.next())
            {
                removeSeatBooked(flightNO, rs.getString(1));
            }
        }
        catch(SQLException e) 
        {
            System.out.println("DB Error arr seat remove");
        }
        updateAvailableSeats(flightNO);
        removeUserFlights(username, flightNO);
    }

    public void removeUserFlights(String username, String flighNO)
    {
        // DELETE FROM rahuls WHERE product_id=1;
        String query = String.format("DELETE from %s where FlightsBooked = \"%s\"",username,flighNO);
        try 
        {
            st.executeUpdate(query);
        } 
        catch(SQLException e) 
        {
            System.out.println("DB Error remove flight from user");
        }
    }


    // Update Available Seats
    public void updateAvailableSeats(String flightNO)//done
    {
        // select count(seatName) from EK507 where seatTaken = 0; 
        int numSeats = 0;
        try
        {
            String query1 = String.format("select count(seatName) as sc from %s where seatTaken = 0",flightNO);
            System.out.println(query1);
            rs = st.executeQuery(query1);
            rs.next();
            numSeats = rs.getInt("sc");
        }
        catch(SQLException e)
        {
            System.out.println("DB Error Get Seat Count");
        }

        String query2 = String.format("UPDATE allflightnum SET numAvailableSeats = %d WHERE flightnum = \"%s\"",numSeats,flightNO);
        try
        {
            st.executeUpdate(query2);
            System.out.println("Successful");
        }
        catch(SQLException ex)
        {
            System.out.println("DB Error Update Seat Count");
        }
    }
    
    /* 
    public void userBookedSeats()
    {
        // SET SQL_SAFE_UPDATES = 0;
        // update ek507 set bookedBy = Null, seatTaken = 0 where bookedBy = "rahuls";
        // SET SQL_SAFE_UPDATES = 1;
    }
    
    
    public void userCancleFlight()
    {
        // call remove seats and userbooked seats
    }
    */
}
