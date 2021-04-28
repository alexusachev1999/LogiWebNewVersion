package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.dao.TruckDAO;
import ru.usachev.LogiWebProject.entity.Truck;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TruckServiceImpl implements TruckService{

    @Autowired
    private TruckDAO truckDAO;

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
    public void saveTruck(Truck truck) {
        truckDAO.saveTruck(truck);
    }
}
