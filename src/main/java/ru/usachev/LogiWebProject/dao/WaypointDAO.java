package ru.usachev.LogiWebProject.dao;

import ru.usachev.LogiWebProject.dto.WaypointDTO;
import ru.usachev.LogiWebProject.entity.Waypoint;

import java.util.List;

public interface WaypointDAO {
    public List<Waypoint> getAllWaypoints();

    public void saveWaypoint(Waypoint waypoint);

    public Waypoint getWaypoint(int id);

    public void deleteWaypoint(int id);

    Waypoint getWaypointByCargoName(String waypointToString);

    List getWaypointListByIds(int[] ids);
}
