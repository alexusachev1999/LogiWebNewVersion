package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.entity.Driver;

import java.util.List;

public interface DriverService {

    public List<Driver> getAllDrivers ();

    public void saveDriver(Driver driver);

    public Driver getDriver(int id);

    public void deleteDriver(int id);

    List<Driver> getDriversByOrderId(int orderId);
}
