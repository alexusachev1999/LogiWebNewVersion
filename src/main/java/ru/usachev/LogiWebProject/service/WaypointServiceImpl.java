package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.converter.WaypointConverter;
import ru.usachev.LogiWebProject.dao.WaypointDAO;
import ru.usachev.LogiWebProject.dto.WaypointDTO;
import ru.usachev.LogiWebProject.entity.Waypoint;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WaypointServiceImpl implements WaypointService{

    @Autowired
    private WaypointDAO waypointDAO;

    @Autowired
    private WaypointConverter waypointConverter;

    @Override
    @Transactional
    public List<Waypoint> getAllWaypoints() {
        return waypointDAO.getAllWaypoints();
    }

    @Override
    @Transactional
    public void saveWaypoint(WaypointDTO waypoint) {
        Waypoint convertedWaypoint = waypointConverter.convertWaypointDTOToWaypoint(waypoint);
        waypointDAO.saveWaypoint(convertedWaypoint);
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
