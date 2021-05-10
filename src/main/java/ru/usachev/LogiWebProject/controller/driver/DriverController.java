package ru.usachev.LogiWebProject.controller.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.usachev.LogiWebProject.dto.DriverDTO;
import ru.usachev.LogiWebProject.dto.OrderDTO;
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


    @GetMapping("/")
    public String showDriverMenu(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();

        String username = userDetail.getUsername();

        DriverDTO driverDTO = driverService.getDriverByUsername(username);

        List<DriverDTO> drivers = driverService.getCoDriverListByUsername(username);

        OrderDTO orderDTO = orderService.getOrderByUsername(username);

        model.addAttribute("driver", driverDTO);
        model.addAttribute("drivers", drivers);
        model.addAttribute("order", orderDTO);
        return "driver/driver-main";
    }
}
