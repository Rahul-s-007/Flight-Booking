package com.example.fms;

public class SuperUser implements intface {
    private String Name;
    private String Username;
    private String Password;

    public SuperUser(String Name,String Username,String Password)//parameterized constructor to initialize all data members
    {
        this.Name=Name;
        this.Username=Username;
        this.Password=Password;
    }
    public SuperUser(String Username,String Password)//parameterized constructor to initialize Username and Password data members only
    {
        this.Username=Username;
        this.Password=Password;
    }
    public SuperUser()//default constructor
    {

    }
    //getter setter methods
    public void setName(String name) {
        Name = name;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getName() {
        return Name;
    }
    public String getPassword() {
        return Password;
    }
    public String getUsername() {
        return Username;
    }
}