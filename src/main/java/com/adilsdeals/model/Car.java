package com.adilsdeals.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * An entity describing a car for rent.
 *
 * @author Patryk Lewczuk,
 */
@Entity
@Table(name = "CAR")
public class Car {

    // I suggest long as id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     *  Field storing a registration number of car
     */
    private String licensePlateNumber;

    /**
     *  Field storing a brand of car
     */
    private String brand;

    /**
     *  Field storing a model of car
     */
    private String model;

    /**
     *  Field storing a manufacturing year of car
     */
    private Integer year;

    /**
     *  Field storing a current market value of car
     */
    private BigDecimal currentMarketValue;

    /**
     *  Field storing a current drove mils of car
     */
    private BigDecimal mileage;

    /**
     *  Field storing a Customer entity which are currently renting car
     */
    private Customer customer;

    /**
     *  Field storing a PickUpLocation entity as geographic location of renting car start
     */
    private PickUpLocation pickUpLocation;

    /**
     * No argument constructor
     */
    public Car() {
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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

    public PickUpLocation getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(PickUpLocation pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }


}
