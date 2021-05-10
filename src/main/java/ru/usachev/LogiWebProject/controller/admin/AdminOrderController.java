package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    private static OrderDTO orderDTOInMemory = new OrderDTO();



    @GetMapping("/orders")
    public String getAllOrders(Model model){
        List<OrderDTO> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);

        return "admin/all-orders";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model){
        int randomInt = (int) (Math.random() * 1000);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setStatus(false);
        orderDTO.setNumber(randomInt);

        orderDTOInMemory.setStatus(false);
        orderDTOInMemory.setNumber(randomInt);

        // Need to return only free waypoints
        List<WaypointDTO> waypoints = waypointService.getAllFreeWaypoints();

        orderDTO.setWaypoints(waypoints);
        model.addAttribute("waypoints", waypoints);
        model.addAttribute("order", orderDTO);
        return "admin/add-order";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@RequestParam("waypoints") List<Integer> cargoIds){

        List<WaypointDTO> waypointsDTO = waypointService.getWaypointListByIds(cargoIds);
        orderDTOInMemory.setWaypoints(waypointsDTO);

        orderService.saveOrder(orderDTOInMemory);
        return "redirect:/admin/order/addTruck";

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

    @GetMapping("/order/addTruck")
    public String addOrderTruck(Model model){
//        List<TruckDTO> trucks = truckService.getValidTrucksForOrder(order.getId());
        List<TruckDTO> trucks = truckService.getAllTrucks();

        model.addAttribute("order", orderDTOInMemory);
        model.addAttribute("trucks", trucks);
        return "admin/order-add-truck";
    }

    @PostMapping("/order/saveTruck")
    public String saveOrderTruck(@RequestParam("truck") String truckNumber,
                                 RedirectAttributes redirectAttributes){

        orderDTOInMemory.setTruck(truckNumber);
        redirectAttributes.addFlashAttribute("order", orderDTOInMemory);

        orderService.saveOrder(orderDTOInMemory);

        return "redirect:/admin/order/addDrivers";
    }

    @GetMapping("/order/addDrivers")
    public String addDriversToOrder(Model model){
//        List<DriverDTO> drivers = driverService.getValidDriversByOrderId(order.getId());

        List<DriverDTO> drivers = driverService.getAllDrivers();

        model.addAttribute("order", orderDTOInMemory);
        model.addAttribute("drivers", drivers);
        return "admin/add-driver-to-order";
    }


    @PostMapping("/order/saveDrivers")
    public String saveDriversToOrder(@RequestParam("drivers") List<Integer> driverIds){
        List<DriverDTO> driversDTO = driverService.getDriverListByIds(driverIds);
        orderDTOInMemory.setDrivers(driversDTO);

        orderService.saveOrder(orderDTOInMemory);
        return "redirect:admin/orders";
    }
}
