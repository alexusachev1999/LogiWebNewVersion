package ru.usachev.LogiWebProject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Waypoint> waypoints;

    @OneToMany(mappedBy = "city")
    private List<Truck> trucks;

    @OneToMany(mappedBy = "city")
    private List<Driver> drivers;

    public City() {
    }

    public void addDriverToDriverList(Driver driver){
        if (drivers == null)
            drivers = new ArrayList<>();
        drivers.add(driver);
        driver.setCity(this);
    }

    public void addTruckToTruckList(Truck truck) {
        if (trucks == null)
            trucks = new ArrayList<>();
        trucks.add(truck);
        truck.setCity(this);
    }

    public void addWaypointToWaypointList(Waypoint waypoint) {
        if (waypoints == null)
            waypoints = new ArrayList<>();
        waypoints.add(waypoint);
        waypoint.setCity(this);
    }


    public City(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

}
