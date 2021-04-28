package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.usachev.LogiWebProject.entity.Cargo;
import ru.usachev.LogiWebProject.service.CargoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCargoController {

    @Autowired
    private CargoService cargoService;

    @RequestMapping("/cargoes")
    public String getAllCargoes(Model model){
        List<Cargo> cargoes = cargoService.getAllCargoes();
        model.addAttribute("cargoes", cargoes);
        return "admin/all-cargoes";
    }

    @RequestMapping("/addCargo")
    public String addCargo(Model model){
        Cargo cargo = new Cargo();
        model.addAttribute("cargo", cargo);
        return "admin/add-cargo";
    }

    @RequestMapping("/saveCargo")
    public String saveCargo(@Valid @ModelAttribute("cargo") Cargo cargo, BindingResult bindingResult
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
        Cargo cargo = cargoService.getCargo(id);
        model.addAttribute("cargo", cargo);
        return "admin/add-cargo";
    }

    @RequestMapping("/deleteCargo")
    public String deleteCargo(@RequestParam(name = "cargoId") int id){
        cargoService.deleteCargo(id);
        return "redirect:/admin/cargoes";
    }
}
