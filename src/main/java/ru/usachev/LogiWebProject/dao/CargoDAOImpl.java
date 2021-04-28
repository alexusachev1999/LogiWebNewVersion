package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.entity.Cargo;
import ru.usachev.LogiWebProject.entity.Waypoint;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CargoDAOImpl implements CargoDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cargo> getAllCargoes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo").getResultList();
    }

    @Override
    public void saveCargo(Cargo cargo) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cargo);
    }

    @Override
    public void deleteCargo(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cargo cargo = session.get(Cargo.class, id);
        session.delete(cargo);
    }

    @Override
    public Cargo getCargo(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cargo cargo = session.get(Cargo.class, id);
        return cargo;
    }

    @Override
    public Cargo getCargoByName(String cargoName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cargo where name=:cargoName");
        query.setParameter("cargoName", cargoName);
        Cargo cargo = (Cargo) query.getSingleResult();
        return cargo;
    }
}
