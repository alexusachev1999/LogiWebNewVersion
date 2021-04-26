package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.Driver;

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
        session.saveOrUpdate(driver);
    }

    @Override
    public Driver getDriver(int id) {
        Session session = sessionFactory.getCurrentSession();
        Driver driver = session.get(Driver.class, id);
        return driver;
    }
}
