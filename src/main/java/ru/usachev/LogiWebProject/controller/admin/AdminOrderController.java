package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.usachev.LogiWebProject.converter.OrderConverter;
import ru.usachev.LogiWebProject.dto.DriverDTO;
import ru.usachev.LogiWebProject.dto.OrderDTO;
import ru.usachev.LogiWebProject.dto.TruckDTO;
import ru.usachev.LogiWebProject.dto.WaypointDTO;
import ru.usachev.LogiWebProject.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CityService cityService;

    @Autowired
    private TruckService truckService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private WaypointService waypointService;

    @Autowired
    private OrderConverter orderConverter;

    @GetMapping("/orders")
    public String getAllOrders(Model model){
        List<OrderDTO> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);

        return "admin/all-orders";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model){
        model.addAttribute("order", new OrderDTO());
        return "admin/add-order";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@Valid @ModelAttribute("order") OrderDTO order, BindingResult bindingResult
            , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("order", new OrderDTO());
            return "admin/add-order";
        }
        else {
            model.addAttribute("order", order);
            orderService.saveOrder(order);
            return "redirect:/admin/order/addWaypoints";
        }
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(@RequestParam("orderId") int id, Model model){
        OrderDTO order = orderConverter.convertOrderToOrderDTO(orderService.getOrder(id));
        model.addAttribute("cityList", cityService.getCities());
        model.addAttribute("order", order);
        return "admin/add-order";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam(name = "orderId") int id){
        orderService.deleteOrder(id);
        return "redirect:/admin/orders";
    }

    @GetMapping("/order/addWaypoints")
    public String addOrderWaypoints(Model model, @ModelAttribute(name = "order") OrderDTO orderDTO){
        List<WaypointDTO> waypoints = waypointService.getAllWaypoints();

        model.addAttribute("order", orderDTO);
        model.addAttribute("waypoints", waypoints);
        return "admin/order-add-waypoints";
    }

    @PostMapping("/order/saveWaypoints")
    public String saveOrderWaypoints(@Valid @ModelAttribute("order") OrderDTO orderDTO
            , BindingResult bindingResult, Model model){
        orderService.saveOrder(orderDTO);
        model.addAttribute("order", orderDTO);
        return "redirect:/admin/order/addTruck";
    }

    @GetMapping("/order/addTruck")
    public String addOrderTruck(Model model, @ModelAttribute(name = "order") OrderDTO order){
        List<TruckDTO> trucks = truckService.getValidTrucksForOrder(order.getId());

        model.addAttribute("order", order);
        model.addAttribute("trucks", trucks);
        return "admin/order-drivers";
    }

    @PostMapping("/order/saveTruck")
    public String saveOrderTruck(@Valid @ModelAttribute("order") OrderDTO order
            , BindingResult bindingResult, Model model){

        model.addAttribute("order", order);
        orderService.saveOrder(order);
        return "redirect:/admin/order/addDrivers";
    }

    @GetMapping("/order/addDrivers")
    public String addDriversToOrder(Model model, @ModelAttribute(name = "order") OrderDTO order){
        List<DriverDTO> drivers = driverService.getValidDriversByOrderId(order.getId());

        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        return "admin/add-driver-to-order";
    }


    @PostMapping("/order/saveDrivers")
    public String saveDriversToOrder(@Valid @ModelAttribute("order") OrderDTO order
            , BindingResult bindingResult){
        orderService.saveOrder(order);
        return "redirect:admin/orders";
    }
}
