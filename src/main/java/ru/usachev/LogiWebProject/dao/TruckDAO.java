package ru.usachev.LogiWebProject.dao;

import ru.usachev.LogiWebProject.entity.Truck;

import java.util.List;

public interface TruckDAO {
    public List<Truck> getAllTrucks();

    public Truck getTruck(int id);

    public void deleteTruck(int id);

    public void saveTruck(Truck truck);
}
