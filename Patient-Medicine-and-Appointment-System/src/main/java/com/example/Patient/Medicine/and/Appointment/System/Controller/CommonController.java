package com.example.Patient.Medicine.and.Appointment.System.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/index")
    public String MainPage(){
        return "index";
    }
}
