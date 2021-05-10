package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.converter.OrderConverter;
import ru.usachev.LogiWebProject.dao.OrderDAO;
import ru.usachev.LogiWebProject.dto.OrderDTO;
import ru.usachev.LogiWebProject.entity.Order;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    @Transactional
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderDAO.getAllOrders();
        List<OrderDTO> convertedOrders = new ArrayList<>();
        for (Order order: orders){
            convertedOrders.add(orderConverter.convertOrderToOrderDTO(order));
        }
        return convertedOrders;
    }

    @Override
    @Transactional
    public void saveOrder(OrderDTO order) {
        orderDAO.saveOrder(orderConverter.convertOrderDTOToOrder(order));
    }

    @Override
    @Transactional
    public Order getOrder(int id) {
        return orderDAO.getOrder(id);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }

    @Override
    @Transactional
    public Order getOrderByNumber(String order) {
        return orderDAO.getOrderByNumber(order);
    }

    @Override
    @Transactional
    public OrderDTO getOrderByUsername(String username) {
        Order order = orderDAO.getOrderByUsername(username);
        OrderDTO orderDTO = orderConverter.convertOrderToOrderDTO(order);
        return orderDTO;
    }
}
