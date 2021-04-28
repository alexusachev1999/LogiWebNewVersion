package ru.usachev.LogiWebProject.service;

import ru.usachev.LogiWebProject.entity.Cargo;

import java.util.List;

public interface CargoService {

    public List<Cargo> getAllCargoes();

    public void saveCargo(Cargo cargo);

    public void deleteCargo(int id);

    public Cargo getCargo(int id);

    Cargo getCargoByName(String cargoName);
}
