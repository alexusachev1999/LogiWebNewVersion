package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.dto.OrderDTO;
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
        Order orderFromDB;

        if (order.getId() != 0){
            orderFromDB = session.get(Order.class, order.getId());
            orderFromDB.setDrivers(order.getDrivers());
            orderFromDB.setTruck(order.getTruck());
            orderFromDB.setWaypoints(order.getWaypoints());

            session.saveOrUpdate(orderFromDB);
        } else {

            session.saveOrUpdate(order);
        }

//
//            List<Waypoint> waypoints = order.getWaypoints();
//
//            for (Waypoint waypoint: waypoints){
//                waypoint.setOrder(order);
//                session.saveOrUpdate(waypoint);
//            }
//
//            if (order.getTruck() != null) {
//                int truckId = order.getTruck().getId();
//                Truck truck = session.get(Truck.class, truckId);
//                truck.setOrder(order);
//                session.saveOrUpdate(truck);
//            }
//
//            if (order.getDrivers() != null) {
//                List<Driver> drivers = order.getDrivers();
//                Truck truck = order.getTruck();
//                for (Driver driver : drivers) {
//                    driver.setOrder(order);
//                    driver.setTruck(truck);
//                    session.update(driver);
//                }
//            }

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

        List<Driver> drivers = order.getDrivers();
        for (Driver driver: drivers){
            driver.setOrder(null);
        }
        session.delete(order);
    }

    @Override
    public Order getOrderByNumber(int number) {
        Session session = sessionFactory.getCurrentSession();
        Order orderByName = new Order();
        orderByName = session.createQuery("from Order where number=:number", Order.class)
                .setParameter("number", number)
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

        List drivers = session.createQuery("from Driver where user.username=:username")
                .setParameter("username", username)
                .getResultList();

        if (drivers != null) {
            Driver driver = (Driver) drivers.get(0);
            Order order = driver.getTruck().getOrder();
            return order;
        } else
            return null;
    }

    @Override
    public void saveDriversToOrder(List<Driver> drivers, Order order) {
        Session session = sessionFactory.getCurrentSession();

        session.update(order);
        for (Driver driver: drivers){
            session.saveOrUpdate(driver);
        }
    }
}
