package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.converter.TruckConverter;
import ru.usachev.LogiWebProject.dao.TruckDAO;
import ru.usachev.LogiWebProject.dto.TruckDTO;
import ru.usachev.LogiWebProject.entity.Truck;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TruckServiceImpl implements TruckService{

    @Autowired
    private TruckDAO truckDAO;

    @Autowired
    private TruckConverter truckConverter;

    @Override
    @Transactional
    public List<Truck> getAllTrucks() {
        return truckDAO.getAllTrucks();
    }

    @Override
    @Transactional
    public Truck getTruck(int id) {
        return truckDAO.getTruck(id);
    }

    @Override
    @Transactional
    public void deleteTruck(int id) {
        truckDAO.deleteTruck(id);
    }

    @Override
    @Transactional
    public void saveTruck(TruckDTO truck) {
        Truck convertedTruck = truckConverter.convertTruckDTOToTruck(truck);
        truckDAO.saveTruck(convertedTruck);
    }

    @Override
    @Transactional
    public List<TruckDTO> getValidTrucksForOrder(int orderId) {
        List<Truck> trucks = truckDAO.getValidTrucksForOrder(orderId);
        List<TruckDTO> convertedTrucks = new ArrayList<>();
        for (Truck truck: trucks){
            convertedTrucks.add(truckConverter.convertTruckToTruckDTO(truck));
        }
        return convertedTrucks;
    }

    @Override
    public Truck getTruckByRegistrationNumber(String registrationNumber) {
        return truckDAO.getTruckByRegistrationNumber(registrationNumber);
    }

    @Override
    public TruckDTO getTruckByOrderId(int orderId) {
        TruckDTO truckDTO = truckConverter.convertTruckToTruckDTO(truckDAO.getTruckByOrderId(orderId));
        return truckDTO;
    }
}
