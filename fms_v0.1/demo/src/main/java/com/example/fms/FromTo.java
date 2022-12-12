package com.example.fms;

public class FromTo {
    private String From;
    private String To;
    
    public FromTo(String From, String To)//Parameterized contructor to initialize all data members
    {
        this.From=From;
        this.To=To;
    }
    public FromTo()// Default Constructor
    {

    }
    public void setFrom(String from) {
        From = from;
    }
    public String getFrom() {
        return From;
    }
    public void setTo(String to) {
        To = to;
    }
    public String getTo() {
        return To;
    }
}
