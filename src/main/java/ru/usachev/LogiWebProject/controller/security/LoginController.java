package ru.usachev.LogiWebProject.controller.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getMainPage(){
        return "start-page";
    }

    @GetMapping("/admin/main")
    public String getAdminMainPage(){
        return "admin/admin-main";
    }

    @GetMapping("/driver/main")
    public String getDriverMainPage(){
        return "driver/driver-main";
    }
}
