package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.dto.TruckDTO;
import ru.usachev.LogiWebProject.entity.Truck;

import java.util.List;

public interface TruckService {
    public List<Truck> getAllTrucks();

    public Truck getTruck(int id);

    public void deleteTruck(int id);

    public void saveTruck(TruckDTO truck);

    public List<TruckDTO> getValidTrucksForOrder(int orderId);

    Truck getTruckByRegistrationNumber(String registrationNumber);

    TruckDTO getTruckByOrderId(int orderId);
}
