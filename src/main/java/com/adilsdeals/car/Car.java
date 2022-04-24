package com.adilsdeals.car;

import java.math.BigDecimal;

public class Car {
    private int id;
    private String licensePlateNumber;
    private String make;
    private String model;
    private int year;
    private BigDecimal currentMarketValue;
    private BigDecimal mileage;
    private Customer customer;
    private PickupLocation pickupLocation(private String latitude, private String longitude);

    // constructor
    public Car(int id, String licensePlateNumber, String make, String model, int year, BigDecimal currentMarketValue, BigDecimal mileage, Customer customer, PickupLocation pickupLocation) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.currentMarketValue = currentMarketValue;
        this.mileage = mileage;
        this.customer = customer;
        this.pickupLocation = pickupLocation;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getCurrentMarketValue() {
        return currentMarketValue;
    }

    public void setCurrentMarketValue(BigDecimal currentMarketValue) {
        this.currentMarketValue = currentMarketValue;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PickupLocation getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
}
