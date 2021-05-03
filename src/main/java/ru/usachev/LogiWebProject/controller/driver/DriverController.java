package ru.usachev.LogiWebProject.controller.driver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DriverController {


    @GetMapping("/driver")
    public String showDriverMenu(){
        return "driver/driver-main";
    }
}
