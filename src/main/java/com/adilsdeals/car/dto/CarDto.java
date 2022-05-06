package com.adilsdeals.car.dto;

import com.adilsdeals.car.models.PickupLocation;
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
    private CarOwnerDto carOwner; // do we want CarOwnerDto or CarOwner here?
    private PickupLocation pickupLocation;
}
