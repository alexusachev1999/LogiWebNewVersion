package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();

    public void saveOrder(Order order);

    public Order getOrder(int id);

    public void deleteOrder(int id);
}
