package com.adilsdeals.car.dto;

import com.adilsdeals.car.models.PickupLocation;
import com.adilsdeals.car_owner.CarOwner;
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
    private CarOwner carOwner;
    private PickupLocation pickupLocation;
}
