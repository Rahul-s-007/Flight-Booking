package com.example.fms;

public class LoginUser {
    private String Name;
    private String Username;
    private String Password;

    public LoginUser(String Name,String Username,String Password)//parameterized constructor to initialize data members
    {
        this.Name=Name;
        this.Username=Username;
        this.Password=Password;
    }
    public LoginUser()//default constructor
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
