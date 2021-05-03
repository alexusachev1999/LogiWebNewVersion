package ru.usachev.LogiWebProject.businessCalculating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.usachev.LogiWebProject.entity.Order;
import ru.usachev.LogiWebProject.entity.Waypoint;
import ru.usachev.LogiWebProject.service.OrderService;

import java.util.List;

@Component
public class BusinessCalculating {

    @Autowired
    private OrderService orderService;

    private static final int driverWorkedHoursLimit = 176;

    public int calculateNeedingCapacityByOrderId(int orderId) {
        int capacity = 0;
        Order order = orderService.getOrder(orderId);
        List<Waypoint> waypoints = order.getWaypoints();

        //Now it's without unloading on way
        for (Waypoint waypoint: waypoints){
            capacity += waypoint.getCargo().getWeight();
        }

        // Cast capacity from kg to t
        Double capacityDouble = ((double) capacity)/1000;
        capacity = (int) Math.round(capacityDouble);

        return capacity;
    }

    public int calculateDriverWorkedHoursLimitForOrderByOrderId(int orderId) {
        Order order = orderService.getOrder(orderId);
        return driverWorkedHoursLimit - calculateApproximateTimeOfOrderExecution(order);
    }

    // Needs jgrapht for calculating shortest way for order
    public int calculateApproximateTimeOfOrderExecution(Order order){
        int ApproximateTimeInHours = 0;



        return ApproximateTimeInHours;
    }

    public int calculateShortestWayForOrderInKm(){
        int shortestWayInKm = 0;


        return shortestWayInKm;
    }
}
