package ru.usachev.LogiWebProject.dto;

public class TruckDTO {
    private int id;
    private String registrationNumber;
    private int driverShiftDuration;
    private int capacity;
    private String city;
    private boolean state;

    public TruckDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getDriverShiftDuration() {
        return driverShiftDuration;
    }

    public void setDriverShiftDuration(int driverShiftDuration) {
        this.driverShiftDuration = driverShiftDuration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Рег. номер: " + registrationNumber;
    }
}
