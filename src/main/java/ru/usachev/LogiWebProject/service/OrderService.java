package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.dto.OrderDTO;
import ru.usachev.LogiWebProject.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    void saveOrder(OrderDTO order);

    Order getOrder(int id);

    void deleteOrder(int id);

    Order getOrderByNumber(String order);

    OrderDTO getOrderByUsername(String username);
}
