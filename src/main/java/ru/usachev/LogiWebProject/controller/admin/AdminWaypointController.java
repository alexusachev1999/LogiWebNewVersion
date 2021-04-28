package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.usachev.LogiWebProject.entity.Cargo;
import ru.usachev.LogiWebProject.entity.City;
import ru.usachev.LogiWebProject.entity.Waypoint;
import ru.usachev.LogiWebProject.service.CargoService;
import ru.usachev.LogiWebProject.service.CityService;
import ru.usachev.LogiWebProject.service.WaypointService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminWaypointController {
    @Autowired
    private WaypointService waypointService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CityService cityService;

    @RequestMapping("/waypoints")
    public String getAllCargoes(Model model){
        List<Waypoint> waypoints = waypointService.getAllWaypoints();
        model.addAttribute("waypoints", waypoints);
        return "admin/all-waypoints";
    }

    @RequestMapping("/addWaypoint")
    public String addCargo(Model model){
        Waypoint waypoint = new Waypoint();
        List<Cargo> cargoes = cargoService.getAllCargoes();
        List<City> cities = cityService.getCities();
        model.addAttribute("waypoint", waypoint);
        model.addAttribute("cargoes", cargoes);
        model.addAttribute("cities", cities);
        return "admin/add-waypoint";
    }

    @RequestMapping("/saveWaypoint")
    public String saveWaypoint(@Valid @ModelAttribute("waypoint") Waypoint waypoint, BindingResult bindingResult, Model model,
                               @RequestParam(name = "cargoId") int cargoId){
        if (bindingResult.hasErrors()) {
            List<Cargo> cargoes = cargoService.getAllCargoes();
            List<City> cities = cityService.getCities();
            model.addAttribute("cargoes", cargoes);
            model.addAttribute("cities", cities);
            return "admin/add-waypoint";
        } else {
            Cargo cargo = cargoService.getCargo(cargoId);
            waypoint.setCargo(cargo);
            waypointService.saveWaypoint(waypoint);
            return "redirect:/admin/waypoints";
        }
    }

    @RequestMapping("/updateWaypoint")
    public String updateWaypoint(@RequestParam("waypointId") int id, Model model){
        Waypoint waypoint = waypointService.getWaypoint(id);
        model.addAttribute("waypoint", waypoint);
        return "admin/add-waypoint";
    }

    @RequestMapping("/deleteWaypoint")
    public String deleteWaypoint(@RequestParam(name = "waypointId") int id){
        waypointService.deleteWaypoint(id);
        return "redirect:/admin/waypoints";
    }

}