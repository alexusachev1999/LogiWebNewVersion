package ru.usachev.LogiWebProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usachev.LogiWebProject.dao.CargoDAO;
import ru.usachev.LogiWebProject.entity.Cargo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoDAO cargoDAO;

    @Override
    @Transactional
    public List<Cargo> getAllCargoes() {
        return cargoDAO.getAllCargoes();
    }

    @Override
    @Transactional
    public void saveCargo(Cargo cargo) {
        cargoDAO.saveCargo(cargo);
    }

    @Override
    @Transactional
    public void deleteCargo(int id) {
        cargoDAO.deleteCargo(id);
    }

    @Override
    @Transactional
    public Cargo getCargo(int id) {
        return cargoDAO.getCargo(id);
    }
}
