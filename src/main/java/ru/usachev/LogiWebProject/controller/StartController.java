package ru.usachev.LogiWebProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.usachev.LogiWebProject.entity.Employee;

@Controller
public class StartController {
    @RequestMapping("/")
    public String showStartPage(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "start-page";
    }

    @RequestMapping("/admin-main")
    public String getAdminMenu(){
        return "admin-main";
    }
}
