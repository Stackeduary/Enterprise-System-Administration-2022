package com.adilsdeals.car.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CarCreateDto {
    private String licensePlateNumber;
    private String make;
    private String model;
    private int year;
    private BigDecimal currentMarketValue;
    private BigDecimal mileage;
    private Customer customer;
    private PickupLocation pickupLocation;
}
