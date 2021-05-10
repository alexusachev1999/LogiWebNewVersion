package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.dto.OrderDTO;
import ru.usachev.LogiWebProject.entity.Order;

import java.util.List;

public interface OrderService {
    public List<OrderDTO> getAllOrders();

    public void saveOrder(OrderDTO order);

    public Order getOrder(int id);

    public void deleteOrder(int id);

    Order getOrderByNumber(String order);

    OrderDTO getOrderByUsername(String username);
}
