package com.adilsdeals.car_owner.dto;

import lombok.Data;

@Data
public class CarOwnerCreateDto {
    private int id;
    private String name;
    private String address;
    private String telephoneNumber;
    private String email;
}
