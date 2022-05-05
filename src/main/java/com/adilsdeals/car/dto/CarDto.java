package com.adilsdeals.car.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CarDto {
    private int id;
    private String licensePlateNumber;
    private String make;
    private String model;
    private int year;
    private BigDecimal currentMarketValue;
    private BigDecimal mileage;
    private CustomerDto customer;
    private PickupLocationDto pickupLocation;
}
