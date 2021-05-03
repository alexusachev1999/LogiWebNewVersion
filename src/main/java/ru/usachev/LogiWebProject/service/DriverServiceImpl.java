package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.converter.DriverConverter;
import ru.usachev.LogiWebProject.dao.DriverDAO;
import ru.usachev.LogiWebProject.dto.DriverDTO;
import ru.usachev.LogiWebProject.entity.Driver;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverDAO driverDAO;

    @Autowired
    private DriverConverter driverConverter;

    @Override
    @Transactional
    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }

    @Override
    @Transactional
    public void saveDriver(DriverDTO driver) {
        Driver convertedDriver = driverConverter.convertDriverDTOToDriver(driver);
        driverDAO.saveDriver(convertedDriver);
    }

    @Override
    @Transactional
    public Driver getDriver(int id) {
        return driverDAO.getDriver(id);
    }

    @Override
    @Transactional
    public void deleteDriver(int id) {
        driverDAO.deleteDriver(id);
    }

    @Override
    @Transactional
    public List<Driver> getDriversByOrderId(int orderId) {
        return driverDAO.getDriversByOrderId(orderId);
    }

    @Override
    public List<DriverDTO> getValidDriversByOrderId(int orderId) {
        List<Driver> drivers = driverDAO.getValidDriversByOrderId(orderId);
        List<DriverDTO> convertedDrivers = driverConverter.convertDriverListToDriverDTOList(drivers);
        return convertedDrivers;
    }
}
