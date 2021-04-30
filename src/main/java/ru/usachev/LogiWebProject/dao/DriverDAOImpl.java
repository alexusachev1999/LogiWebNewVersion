package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.City;
import ru.usachev.LogiWebProject.entity.Driver;

import javax.persistence.Query;
import java.util.List;

@Repository
public class DriverDAOImpl implements DriverDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Driver> getAllDrivers() {
        Session session = sessionFactory.getCurrentSession();
        List<Driver> drivers = session.createQuery("from Driver", Driver.class).getResultList();
        return drivers;
    }

    @Override
    public void saveDriver(Driver driver) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from City where name=:cityName ");
        query.setParameter("cityName", driver.getCity().getName());

        City city = (City) query.getSingleResult();
        city.addDriverToDriverList(driver);
        session.saveOrUpdate(driver);
    }

    @Override
    public Driver getDriver(int id) {
        Session session = sessionFactory.getCurrentSession();
        Driver driver = session.get(Driver.class, id);
        return driver;
    }

    @Override
    public void deleteDriver(int id) {
        Session session = sessionFactory.getCurrentSession();
        Driver driver = session.get(Driver.class, id);
        session.delete(driver);
    }

    @Override
    public List<Driver> getDriversByOrderId(int orderId) {
        Session session = sessionFactory.getCurrentSession();

        List<Driver> drivers = session.createQuery("from Driver where order=:orderId")
                .setParameter("orderId", orderId)
                .getResultList();
        return drivers;
    }
}
