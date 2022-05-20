package com.adilsdeals.car_rent.dto;

import com.adilsdeals.models.Duration;
import lombok.Data;

@Data
public class CarRentDto {
    private Integer id;
    private Duration rentTime;
    private int car;
    private String renter;
}
