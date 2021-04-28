package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.dao.WaypointDAO;
import ru.usachev.LogiWebProject.entity.Waypoint;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WaypointServiceImpl implements WaypointService{

    @Autowired
    private WaypointDAO waypointDAO;

    @Override
    @Transactional
    public List<Waypoint> getAllWaypoints() {
        return waypointDAO.getAllWaypoints();
    }

    @Override
    @Transactional
    public void saveWaypoint(Waypoint waypoint) {
        waypointDAO.saveWaypoint(waypoint);
    }

    @Override
    @Transactional
    public Waypoint getWaypoint(int id) {
        return waypointDAO.getWaypoint(id);
    }

    @Override
    @Transactional
    public void deleteWaypoint(int id) {
        waypointDAO.deleteWaypoint(id);
    }
}
