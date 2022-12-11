package com.example.fms;

public class NewUser extends SuperUser {

    public NewUser(String Name,String Username,String Password)//parameterized constructor to initialize data members
    {
        super(Name,Username,Password);
        //this.Name=Name;
        //this.Username=Username;
        //this.Password=Password;
    }
    public NewUser()//default constructor
    {

    }

}
