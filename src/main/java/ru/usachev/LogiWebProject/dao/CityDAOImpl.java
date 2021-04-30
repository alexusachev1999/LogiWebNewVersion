package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.entity.City;

import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public City getCityById(int id) {
        Session session = sessionFactory.getCurrentSession();
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    public List<City> getCities() {
        Session session = sessionFactory.getCurrentSession();
        List<City> cities = session.createQuery("from City", City.class).getResultList();
        return cities;
    }

    @Override
    public City getCityByName(String cityName) {
        Session session = sessionFactory.getCurrentSession();
        City city = new City();

        city = session.createQuery("from City where name=:cityName", City.class)
                .setParameter("cityName", cityName)
                .getSingleResult();
        return city;
    }
}
