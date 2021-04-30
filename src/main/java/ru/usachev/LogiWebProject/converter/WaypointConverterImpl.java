package ru.usachev.LogiWebProject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.usachev.LogiWebProject.dto.WaypointDTO;
import ru.usachev.LogiWebProject.entity.Waypoint;
import ru.usachev.LogiWebProject.service.CargoService;
import ru.usachev.LogiWebProject.service.CityService;


@Component
public class WaypointConverterImpl implements WaypointConverter{

    @Autowired
    private CityService cityService;

    @Autowired
    private CargoService cargoService;

    public Waypoint convertWaypointDTOToWaypoint(WaypointDTO waypoint) {
        Waypoint convertedWaypoint = new Waypoint();

        convertedWaypoint.setId(waypoint.getId());
        convertedWaypoint.setCity(cityService.getCityByName(waypoint.getCity()));
        convertedWaypoint.setLoading(waypoint.isType());
        convertedWaypoint.setCargo(cargoService.getCargoByName(waypoint.getCargo()));

        return convertedWaypoint;
    }

    @Override
    public WaypointDTO convertWaypointToWaypointDTO(Waypoint waypoint) {
        WaypointDTO waypointDTO = new WaypointDTO();

        waypointDTO.setId(waypoint.getId());
        waypointDTO.setCity(waypoint.getCity().getName());
        waypointDTO.setCargo(waypoint.getCargo().getName());
        waypointDTO.setType(waypoint.isLoading());

        return waypointDTO;
    }
}
