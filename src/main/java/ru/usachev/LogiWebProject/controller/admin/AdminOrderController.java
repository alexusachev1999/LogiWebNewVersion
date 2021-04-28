package ru.usachev.LogiWebProject.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.usachev.LogiWebProject.entity.Driver;
import ru.usachev.LogiWebProject.entity.Order;
import ru.usachev.LogiWebProject.entity.Truck;
import ru.usachev.LogiWebProject.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CityService cityService;

    @Autowired
    private TruckService truckService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/orders")
    public String getAllOrders(Model model){
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);

        return "admin/all-orders";
    }

    @RequestMapping("/addOrder")
    public String addDriver(Model model){
        Order order = new Order();
        List<Driver> drivers = driverService.getAllDrivers();
        List<Truck> trucks = truckService.getAllTrucks();

        model.addAttribute("order", order);
        model.addAttribute("drivers", drivers);
        model.addAttribute("trucks", trucks);
        return "admin/add-order";
    }

    @RequestMapping("/saveOrder")
    public String saveDriver(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult
            , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("cityList", cityService.getCities());
            return "admin/add-order";}
        else {
            orderService.saveOrder(order);
            return "redirect:/admin/orders";
        }
    }

    @RequestMapping("/updateOrder")
    public String updateDriver(@RequestParam("orderId") int id, Model model){
        Order order = orderService.getOrder(id);
        model.addAttribute("cityList", cityService.getCities());
        model.addAttribute("order", order);
        return "admin/add-order";
    }

    @RequestMapping("/deleteOrder")
    public String deleteDriver(@RequestParam(name = "orderId") int id){
        orderService.deleteOrder(id);
        return "redirect:/admin/orders";
    }

    @RequestMapping("/order/detail")
    public String getOrderDetail(){
        return "order-detail";
    }

    @RequestMapping("/order/drivers")
    public String getOrderWaypoints(@RequestParam(name = "orderId") int id){
        return "order-drivers";
    }
}
