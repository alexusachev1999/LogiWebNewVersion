package ru.usachev.LogiWebProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.usachev.LogiWebProject.entity.Driver;
import ru.usachev.LogiWebProject.service.DriverService;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private DriverService driverService;
    @RequestMapping("/admin")
    public String showAdminMenu(){
        return "admin-main";
    }

    @RequestMapping("/admin/drivers")
    public String getAllDrivers(Model model){
        List<Driver> drivers = driverService.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "all-drivers";
    }

    @RequestMapping("/admin/addDriver")
    public String addDriver(Model model){
        Driver driver = new Driver();
        model.addAttribute("driver", driver);
        return "add-driver";
    }

    @RequestMapping("/admin/saveDriver")
    public String saveDriver(@ModelAttribute("driver") Driver driver){
        driverService.saveDriver(driver);
        return "redirect:/admin/drivers";
    }

    @RequestMapping("/admin/updateDriver")
    public String updateDriver(@RequestParam("driverId") int id, Model model){
        Driver driver = driverService.getDriver(id);
        model.addAttribute("driver");
        return "add-driver";
    }
}
