package ru.usachev.LogiWebProject.controller.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.usachev.LogiWebProject.dto.CargoDTO;
import ru.usachev.LogiWebProject.dto.DriverDTO;
import ru.usachev.LogiWebProject.dto.OrderDTO;
import ru.usachev.LogiWebProject.entity.Cargo;
import ru.usachev.LogiWebProject.service.CargoService;
import ru.usachev.LogiWebProject.service.DriverService;
import ru.usachev.LogiWebProject.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CargoService cargoService;

    private String username;
    private DriverDTO driverDTO;

    @GetMapping("/")
    public String showDriverMenu(Model model){
        /* Getting driver by username which getting from security form
         * Set into private static object which will use in different
         * methods of this controller*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        username = userDetail.getUsername();
        driverDTO = driverService.getDriverByUsername(username);

        /* Get driver list by this username */
        List<DriverDTO> drivers = driverService.getCoDriverListByUsername(username);
        drivers.removeIf(driver -> driver.getUser().equals(username));

        /* Get order for this driver*/
        OrderDTO orderDTO = orderService.getOrderByUsername(username);

        /* Flags for JSP <c:if test = "isFlag"> */
        boolean isDriverListEmpty = drivers.isEmpty();
        boolean isDriverHasOrder = !(orderDTO == null);

        model.addAttribute("isDriverHasOrder", isDriverHasOrder);
        model.addAttribute("isDriverListEmpty", isDriverListEmpty);
        model.addAttribute("driver", driverDTO);
        model.addAttribute("drivers", drivers);
        model.addAttribute("order", orderDTO);
        return "driver/driver-main";
    }

    @GetMapping("/changeWorkTimeStatus")
    public String changeWorkTimeStatus(Model model){
        model.addAttribute("driver", driverDTO);
        return "driver/change-work-time-status";
    }

    @PostMapping("/saveNewWorkTimeStatus")
    public String saveNewWorkTimeStatus(@ModelAttribute(name = "driver") DriverDTO driver){
        driverService.updateDriver(driver);
        return "redirect:/driver/";
    }

    @GetMapping("/changeWorkType")
    public String changeWorkType(Model model){
        model.addAttribute("driver", driverDTO);
        return "driver/change-work-type";
    }

    @PostMapping("/saveNewWorkType")
    public String saveNewWorkType(@ModelAttribute(name = "driver") DriverDTO driver){
        driverService.updateDriver(driver);
        return "redirect:/driver/";
    }

    @GetMapping("/changeCargoStatus")
    public String changeCargoStatus(@RequestParam (name = "waypointId") int waypointId
            , Model model){
        CargoDTO cargoDTO = cargoService.getCargoByWaypointId(waypointId);
        model.addAttribute("cargo", cargoDTO);
        return "driver/change-cargo-status";
    }

    @PostMapping("/saveNewCargoStatus")
    public String saveNewCargoStatus(@ModelAttribute(name = "cargo") CargoDTO cargoDTO){
        cargoService.saveCargo(cargoDTO);
        return "redirect:/driver/";
    }


}
