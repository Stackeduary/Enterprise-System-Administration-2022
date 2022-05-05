package com.adilsdeals.car;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity(name = "car")

public class Car {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Setter(AccessLevel.NONE)
    @Column(name = "name", nullable = false, unique = true)
    private String licensePlateNumber;

    @Setter(AccessLevel.NONE)
    @Column(name = "model", nullable = false)
    private String make;

    @Setter(AccessLevel.NONE)
    @Column(name = "model", nullable = false)
    private String model;

    @Setter(AccessLevel.NONE)
    @Column(name = "year", nullable = false)
    private int year;

    @Setter(AccessLevel.NONE)
    @Column(name = "currentMarketValue", nullable = false)
    private BigDecimal currentMarketValue;

    @Setter(AccessLevel.NONE)
    @Column(name = "mileage", nullable = false)
    private BigDecimal mileage;
    
    @Setter(AccessLevel.NONE)
    @Column(name = "customer", nullable = false)
    private Customer customer;

    @Setter(AccessLevel.NONE)
    @Column(name = "pickupLocation", nullable = false)
    private PickupLocation pickupLocation(private String latitude, private String longitude);
}
