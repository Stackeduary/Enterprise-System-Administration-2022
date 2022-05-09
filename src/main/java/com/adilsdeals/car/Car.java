package com.adilsdeals.car;

import com.adilsdeals.models.PickupLocation;
import com.adilsdeals.car_owner.CarOwner;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "car")
public class Car {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "license_plate_number", nullable = false, unique = true)
    private String licensePlateNumber;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "current_market_value", nullable = false)
    private BigDecimal currentMarketValue;

    @Column(name = "mileage", nullable = false)
    private BigDecimal mileage;

    @JoinColumn(name = "car_owner", nullable = false)
    @ManyToOne()
    private CarOwner carOwner;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "longitude"))
    })
    private PickupLocation pickupLocation;
}
