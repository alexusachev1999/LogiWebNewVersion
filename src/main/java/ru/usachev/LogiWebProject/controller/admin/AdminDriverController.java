package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.usachev.LogiWebProject.entity.Driver;
import ru.usachev.LogiWebProject.service.CityService;
import ru.usachev.LogiWebProject.service.DriverService;
import ru.usachev.LogiWebProject.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private CityService cityService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAdminMenu(){
        return "admin/admin-main";
    }

    @RequestMapping("/drivers")
    public String getAllDrivers(Model model){
        List<Driver> drivers = driverService.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "admin/all-drivers";
    }

    @RequestMapping("/addDriver")
    public String addDriver(Model model){
        Driver driver = new Driver();
        model.addAttribute("driver", driver);
        model.addAttribute("cityList", cityService.getCities());
        return "admin/add-driver";
    }

    @RequestMapping("/saveDriver")
    public String saveDriver(@Valid @ModelAttribute("driver") Driver driver, BindingResult bindingResult
    , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("cityList", cityService.getCities());
            return "admin/add-driver";}
        else {
            driverService.saveDriver(driver);
            return "redirect:/admin/drivers";
        }
    }

    @RequestMapping("/updateDriver")
    public String updateDriver(@RequestParam("driverId") int id, Model model){
        Driver driver = driverService.getDriver(id);
        model.addAttribute("cityList", cityService.getCities());
        model.addAttribute("driver", driver);
        return "admin/add-driver";
    }

    @RequestMapping("/deleteDriver")
    public String deleteDriver(@RequestParam(name = "driverId") int id){
        driverService.deleteDriver(id);
        return "redirect:/admin/drivers";
    }
}
