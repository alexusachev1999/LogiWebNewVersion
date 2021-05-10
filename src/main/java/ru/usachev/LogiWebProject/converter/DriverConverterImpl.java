package ru.usachev.LogiWebProject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.usachev.LogiWebProject.dto.DriverDTO;
import ru.usachev.LogiWebProject.entity.Driver;
import ru.usachev.LogiWebProject.service.CityService;
import ru.usachev.LogiWebProject.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverConverterImpl implements DriverConverter{

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Override
    public Driver convertDriverDTOToDriver(DriverDTO driver) {
        Driver convertedDriver = new Driver();

        convertedDriver.setId(driver.getId());
        convertedDriver.setName(driver.getName());
        convertedDriver.setSurname(driver.getSurname());
        convertedDriver.setPhoneNumber(driver.getPhoneNumber());
        convertedDriver.setStatus(driver.getStatus());
        convertedDriver.setOrder(null);
        convertedDriver.setCity(cityService.getCityByName(driver.getCity()));
        convertedDriver.setTruck(null);
        convertedDriver.setWorkedHours(0);
        convertedDriver.setUser(userService.getUserByUsername(driver.getUser()));
        return convertedDriver;
    }

    @Override
    public DriverDTO convertDriverToDriverDTO(Driver driver) {
        DriverDTO convertedDriver = new DriverDTO();

        convertedDriver.setId(driver.getId());
        convertedDriver.setName(driver.getName());
        convertedDriver.setSurname(driver.getSurname());
        convertedDriver.setPhoneNumber(driver.getPhoneNumber());
        convertedDriver.setStatus(driver.getStatus());
        convertedDriver.setCity(driver.getCity().getName());
        convertedDriver.setUser(driver.getUser().getUsername());

        return convertedDriver;
    }

    @Override
    public List<Driver> convertDriverDTOListToDriverList(List<DriverDTO> driversDTO) {
        List<Driver> drivers = new ArrayList<>();
        for (DriverDTO driverDTO: driversDTO){
            drivers.add(convertDriverDTOToDriver(driverDTO));
        }
        return drivers;
    }

    @Override
    public List<DriverDTO> convertDriverListToDriverDTOList(List<Driver> drivers) {
        List<DriverDTO> driversDTO = new ArrayList<>();
        for(Driver driver: drivers){
            driversDTO.add(convertDriverToDriverDTO(driver));
        }
        return driversDTO;
    }
}
