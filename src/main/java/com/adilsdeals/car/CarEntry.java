package com.adilsdeals.car;

public class CarEntry {
    private boolean available;
    private Car car;

    // constructor
    public CarEntry(boolean available, Car car) {
        this.available = available;
        this.car = car;
    }

    // getters and setters
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
