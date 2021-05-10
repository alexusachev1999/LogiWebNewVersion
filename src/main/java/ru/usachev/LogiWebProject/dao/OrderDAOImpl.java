package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.Driver;
import ru.usachev.LogiWebProject.entity.Order;
import ru.usachev.LogiWebProject.entity.Truck;
import ru.usachev.LogiWebProject.entity.Waypoint;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        List<Order> orders = session.createQuery("from Order").getResultList();

        try {
            return orders;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        List<Waypoint> waypoints = order.getWaypoints();

        for (Waypoint waypoint: waypoints){
            waypoint.setOrder(order);
            session.update(waypoint);
        }

        if (order.getTruck() != null) {
            int truckId = order.getTruck().getId();
            Truck truck = session.get(Truck.class, truckId);
            truck.setOrder(order);
            session.update(truck);
        }

        if (order.getDrivers() != null) {
            List<Driver> drivers = order.getDrivers();
            int truckId = order.getTruck().getId();
            Truck truck = session.get(Truck.class, truckId);
            for (Driver driver : drivers) {
                driver.setOrder(order);
                driver.setTruck(truck);
                session.update(driver);
            }
        }

        session.saveOrUpdate(order);
    }

    @Override
    public Order getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);

        try {
            return order;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);

        // To exclude constraint exception - set order_id null for waypoints which have this order
        List<Waypoint> waypoints = order.getWaypoints();
        for (Waypoint waypoint: waypoints){
            waypoint.setOrder(null);
        }
        session.delete(order);
    }

    @Override
    public Order getOrderByNumber(String order) {
        Session session = sessionFactory.getCurrentSession();
        Order orderByName = new Order();
        Integer orderNumber = Integer.getInteger(order);
        orderByName = session.createQuery("from Order where number=:number", Order.class)
                .setParameter("number", orderNumber)
                .getSingleResult();

        try {
            return orderByName;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Order getOrderByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        List<Driver> drivers = session.createQuery("from Driver where user.username=:username")
                .setParameter("username", username)
                .getResultList();

        if (drivers != null) {
            Driver driver = drivers.get(0);
            int orderId = driver.getOrder().getId();
            Order order = session.get(Order.class, orderId);
            return order;
        } else
            return null;
    }
}
