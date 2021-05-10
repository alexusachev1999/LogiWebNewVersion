package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.usachev.LogiWebProject.converter.DriverConverter;
import ru.usachev.LogiWebProject.dto.DriverDTO;
import ru.usachev.LogiWebProject.entity.Driver;
import ru.usachev.LogiWebProject.service.CityService;
import ru.usachev.LogiWebProject.service.DriverService;
import ru.usachev.LogiWebProject.service.UserService;

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
    private UserService userService;

    @Autowired
    private DriverConverter driverConverter;

    @RequestMapping("/")
    public String showAdminMenu(){
        return "admin/admin-main";
    }

    @RequestMapping("/drivers")
    public String getAllDrivers(Model model){
        List<DriverDTO> drivers = driverService.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "admin/all-drivers";
    }

    @GetMapping("/addDriver")
    public String addDriver(Model model){
        DriverDTO driver = new DriverDTO();
        model.addAttribute("driver", driver);
        model.addAttribute("cityList", cityService.getCities());
        model.addAttribute("freeUserForDrivers", userService.freeUserForDrivers());
        return "admin/add-driver";
    }

    @PostMapping(value = "/saveDriver", produces = "text/plain;charset=UTF-8")
    public String saveDriver(@Valid @ModelAttribute("driver") DriverDTO driver, BindingResult bindingResult
    , Model model){
        if (bindingResult.hasErrors()){

            model.addAttribute("driver", driver);
            model.addAttribute("cityList", cityService.getCities());
            return "admin/add-driver";}
        else {
            driverService.saveDriver(driver);
            return "redirect:/admin/drivers";
        }
    }

    @RequestMapping("/updateDriver")
    public String updateDriver(@RequestParam("driverId") int id, Model model){
        DriverDTO driver = driverConverter.convertDriverToDriverDTO(driverService.getDriver(id));
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
