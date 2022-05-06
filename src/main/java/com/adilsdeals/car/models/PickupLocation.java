package com.adilsdeals.car.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
public class PickupLocation {
    private String latitude;
    private String longitude;
}
