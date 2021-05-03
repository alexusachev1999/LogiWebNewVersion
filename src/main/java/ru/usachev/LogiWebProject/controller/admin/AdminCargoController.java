package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.usachev.LogiWebProject.converter.CargoConverter;
import ru.usachev.LogiWebProject.dto.CargoDTO;
import ru.usachev.LogiWebProject.entity.Cargo;
import ru.usachev.LogiWebProject.service.CargoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CargoConverter cargoConverter;

    @RequestMapping("/cargoes")
    public String getAllCargoes(Model model){
        List<Cargo> cargoes = cargoService.getAllCargoes();
        model.addAttribute("cargoes", cargoes);
        return "admin/all-cargoes";
    }

    @GetMapping("/addCargo")
    public String addCargo(Model model){
        CargoDTO cargo = new CargoDTO();
        model.addAttribute("cargo", cargo);
        return "admin/add-cargo";
    }

    @PostMapping("/saveCargo")
    public String saveCargo(@Valid @ModelAttribute("cargo") CargoDTO cargo, BindingResult bindingResult
            , Model model){
        if (bindingResult.hasErrors()){
            return "admin/add-cargo";}
        else {
            cargoService.saveCargo(cargo);
            return "redirect:/admin/cargoes";
        }
    }

    @RequestMapping("/updateCargo")
    public String updateCargo(@RequestParam("cargoId") int id, Model model){
        CargoDTO cargo = cargoConverter.convertCargoToCargoDTO(cargoService.getCargo(id));
        model.addAttribute("cargo", cargo);
        return "admin/add-cargo";
    }

    @RequestMapping("/deleteCargo")
    public String deleteCargo(@RequestParam(name = "cargoId") int id){
        cargoService.deleteCargo(id);
        return "redirect:/admin/cargoes";
    }
}
