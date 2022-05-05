package com.adilsdeals.car_repair.dto;

import com.adilsdeals.models.Duration;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarRepairDto {
    private String status;
    private Duration repairTime;
}
