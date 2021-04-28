package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.entity.Waypoint;

import java.util.List;

public interface WaypointService {
    public List<Waypoint> getAllWaypoints();

    public void saveWaypoint(Waypoint waypoint);

    public Waypoint getWaypoint(int id);

    public void deleteWaypoint(int id);
}
