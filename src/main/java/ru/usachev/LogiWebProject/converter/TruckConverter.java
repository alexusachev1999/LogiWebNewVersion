package ru.usachev.LogiWebProject.converter;

import ru.usachev.LogiWebProject.dto.TruckDTO;
import ru.usachev.LogiWebProject.entity.Truck;

public interface TruckConverter {
    Truck convertTruckDTOToTruck(TruckDTO truckDTO);

    TruckDTO convertTruckToTruckDTO(Truck truck);
}
