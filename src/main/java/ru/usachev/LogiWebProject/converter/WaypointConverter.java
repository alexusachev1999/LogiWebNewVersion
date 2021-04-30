package ru.usachev.LogiWebProject.converter;

import ru.usachev.LogiWebProject.dto.WaypointDTO;
import ru.usachev.LogiWebProject.entity.Waypoint;

public interface WaypointConverter {
    Waypoint convertWaypointDTOToWaypoint(WaypointDTO waypoint);

    WaypointDTO convertWaypointToWaypointDTO(Waypoint waypoint);
}
