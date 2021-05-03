package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.businessCalculating.BusinessCalculating;
import ru.usachev.LogiWebProject.entity.City;
import ru.usachev.LogiWebProject.entity.Order;
import ru.usachev.LogiWebProject.entity.Truck;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TruckDAOImpl implements TruckDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BusinessCalculating calculating;

    @Override
    public List<Truck> getAllTrucks() {
        Session session = sessionFactory.getCurrentSession();
        List<Truck> trucks = session.createQuery("from Truck ").getResultList();
        return trucks;
    }

    @Override
    public Truck getTruck(int id) {
        Session session = sessionFactory.getCurrentSession();
        Truck truck = session.get(Truck.class, id);
        return truck;
    }

    @Override
    public void deleteTruck(int id) {
        Session session = sessionFactory.getCurrentSession();
        Truck truck = session.get(Truck.class, id);
        session.delete(truck);
    }

    @Override
    public void saveTruck(Truck truck) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from City where name=:cityName ");
        query.setParameter("cityName", truck.getCity().getName());
        City city = (City) query.getSingleResult();
        city.addTruckToTruckList(truck);
        session.saveOrUpdate(truck);
    }

    @Override
    public List<Truck> getValidTrucksForOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        int needingCapacity = calculating.calculateNeedingCapacityByOrderId(orderId);
        Query query = session.createQuery("from Truck where state=true and " +
                "capacity<=:capacity and order = null");
        query.setParameter("capacity", needingCapacity);
        return query.getResultList();
    }

    @Override
    public Truck getTruckByRegistrationNumber(String registrationNumber) {
        Session session = sessionFactory.getCurrentSession();
        Truck truck = session.createQuery("from Truck where registrationNumber=:regNumber", Truck.class)
                .setParameter("regNumber", registrationNumber).getSingleResult();
        return truck;
    }

    @Override
    public Truck getTruckByOrderId(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Truck truck = session.createQuery("from Truck where Order.id=:orderId", Truck.class)
                .setParameter("orderId", orderId).getSingleResult();
        return truck;
    }
}
