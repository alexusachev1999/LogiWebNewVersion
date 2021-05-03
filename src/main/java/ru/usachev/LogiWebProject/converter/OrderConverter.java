package ru.usachev.LogiWebProject.converter;

import ru.usachev.LogiWebProject.dto.OrderDTO;
import ru.usachev.LogiWebProject.entity.Order;

public interface OrderConverter {
    Order convertOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO convertOrderToOrderDTO(Order order);
}
