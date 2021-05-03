package ru.usachev.LogiWebProject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.usachev.LogiWebProject.dto.WaypointDTO;
import ru.usachev.LogiWebProject.entity.Cargo;
import ru.usachev.LogiWebProject.entity.City;
import ru.usachev.LogiWebProject.entity.Waypoint;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaypointDAOImpl implements WaypointDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Waypoint> getAllWaypoints() {
        Session session = sessionFactory.getCurrentSession();
        List<Waypoint> waypoints = session.createQuery("from Waypoint").getResultList();
        return waypoints;
    }

    @Override
    public void saveWaypoint(Waypoint waypoint) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Cargo where name=:cargoName");
        query.setParameter("cargoName", waypoint.getCargo().getName());
        Cargo cargo = (Cargo) query.getSingleResult();
        cargo.addWaypointToWaypoints(waypoint);


        Query query2 = session.createQuery("from City where name=:cityLoadingName ");
        query2.setParameter("cityLoadingName", waypoint.getCityLoading().getName());
        City cityLoading = (City) query2.getSingleResult();
        cityLoading.addWaypointToLoadingWaypointList(waypoint);

        Query query3 = session.createQuery("from City where name=:cityUnloadingName ");
        query3.setParameter("cityUnloadingName", waypoint.getCityUnloading().getName());
        City cityUnloading = (City) query3.getSingleResult();
        cityUnloading.addWaypointToUnloadingWaypointList(waypoint);

        session.saveOrUpdate(waypoint);
    }

    @Override
    public Waypoint getWaypoint(int id) {
        Session session = sessionFactory.getCurrentSession();
        Waypoint waypoint = session.get(Waypoint.class, id);
        return waypoint;
    }

    @Override
    public void deleteWaypoint(int id) {
        Session session = sessionFactory.getCurrentSession();
        Waypoint waypoint = session.get(Waypoint.class, id);
        session.delete(waypoint);
    }

    @Override
    public Waypoint getWaypointByCargoName(String waypointToString) {
        Session session = sessionFactory.getCurrentSession();

        Waypoint waypoint = session.createQuery("from Waypoint where cargo.name=:name", Waypoint.class)
                .setParameter("name", waypointToString)
                .getSingleResult();
        return waypoint;
    }

    @Override
    public List getWaypointListByIds(int[] ids) {
        Session session = sessionFactory.getCurrentSession();

        List waypoints = new ArrayList<>();

        for (int id: ids){
            Waypoint waypoint = session.get(Waypoint.class, id);
            waypoints.add(waypoint);
        }

        return waypoints;
    }
}
