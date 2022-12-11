package com.example.fms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BSController 
{
    
    @GetMapping("/contact")
    public String getContact()
    {
        return "contact";
    }
}
