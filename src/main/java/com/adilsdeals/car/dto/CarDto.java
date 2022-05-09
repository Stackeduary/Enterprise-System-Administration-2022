package com.adilsdeals.car.dto;

import com.adilsdeals.models.PickupLocation;
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
    private int carOwnerId;
    private PickupLocation pickupLocation;
}
