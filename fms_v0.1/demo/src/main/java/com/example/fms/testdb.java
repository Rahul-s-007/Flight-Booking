package com.example.fms;

import java.sql.*;
//import javax.swing.*;

public class testdb {
    public String ans="";
    private Connection con;
    private Statement st;
    private ResultSet rs;

    //Constructor
    public testdb()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","7703");
            st=con.createStatement();
        }catch(ClassNotFoundException | SQLException ex)
        {
            //JOptionPane.showMessageDialog(null,"Error: "+ex);
            System.out.println("Error");
        }
    }
    
    public String exeQuery(String query) //to get table output
    {
        try
        {
            //st.executeQuery(query);
            rs = st.executeQuery(query);
            while(rs.next())
            {
                    //System.out.println(rs.getString(1));
                    //System.out.println(rs.getString(2));
                    //System.out.println(rs.getString(3));
                    //System.out.println("-------------");
                    ans += rs.getString(1)  +" "+ rs.getString(2) +" "+ rs.getString(3) +"\n";
            }
            return ans;
        }
        catch(SQLException ex)
        {
            //JOptionPane.showMessageDialog(null,"Error:"+ex);
            System.out.println("Error");
            return ex.toString();
        }
    }
    
    public String getans()
    {
        String query = "describe bmi";
        String temp = exeQuery(query);
        return temp;
    }

    // Example input
    public String rahul(FlightInfoUser ob)
    {
        ob.getPassengers();
        return "bruh";
    }


    // F1
    public String getAvailableFlights(FlightInfoUser ob)
    {
        Date date = ob.getDate();
        String to = ob.getTo();
        String from = ob.getFrom();
        int passengers = ob.getPassengers();

        String query = String.format("Select FlightID from FlightDetails Where to=%s and from=%s and date=%t and num_seats >= %d",to,from,date,passengers);

        // edit the output below
        try
        {
            rs = st.executeQuery(query);
            while(rs.next())
            {
                    //System.out.println(rs.getString(1));
                    //System.out.println(rs.getString(2));
                    //System.out.println(rs.getString(3));
                    //System.out.println("-------------");
                    ans += rs.getString(1)  +" "+ rs.getString(2) +" "+ rs.getString(3) +"\n";
            }
            return ans;
        }
        catch(SQLException ex)
        {
            //JOptionPane.showMessageDialog(null,"Error:"+ex);
            System.out.println("Error");
            return ex.toString();
        }
    }

    //F2 
    public String userLoginCheck(FlightInfoUser ob)
    {
        //
        return "";
    }


    public static void main(String args[])
    {
        testdb cdb = new testdb();
        String query;
        //query = "show tables";
        //cdb.exeQuery(query);
        query = "describe bmi";
        cdb.exeQuery(query);
        System.out.println(cdb.ans);
    }
}

