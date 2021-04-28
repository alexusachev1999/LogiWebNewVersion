package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.usachev.LogiWebProject.entity.Driver;
import ru.usachev.LogiWebProject.entity.Truck;
import ru.usachev.LogiWebProject.service.CityService;
import ru.usachev.LogiWebProject.service.TruckService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminTruckController {

    @Autowired
    private TruckService truckService;

    @Autowired
    private CityService cityService;

    @RequestMapping("/trucks")
    private String getAllTrucks(Model model){
        List<Truck> trucks = truckService.getAllTrucks();
        model.addAttribute("trucks", trucks);
        return "/admin/all-trucks";
    }

    @RequestMapping("/addTruck")
    public String addTruck(Model model){
        Truck truck = new Truck();
        model.addAttribute("truck", truck);
        model.addAttribute("cityList", cityService.getCities());
        return "admin/add-new-truck";
    }

    @RequestMapping("/updateTruck")
    private String updateTruck(@RequestParam("truckId") int id, Model model){
        Truck truck = truckService.getTruck(id);
        model.addAttribute("cityList", cityService.getCities());
        model.addAttribute("truck", truck);
        return "admin/add-new-truck";
    }

    @RequestMapping("/deleteTruck")
    public String deleteDriver(@RequestParam(name = "truckId") int id){
        truckService.deleteTruck(id);

        return "redirect:/admin/trucks";
    }

    @RequestMapping("/saveTruck")
    private String saveTruck(@Valid @ModelAttribute("truck") Truck truck, BindingResult bindingResult
    , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("cityList", cityService.getCities());
            return "admin/add-new-truck";}
        else {
            truckService.saveTruck(truck);
            return "redirect:/admin/trucks";
        }
    }
}
