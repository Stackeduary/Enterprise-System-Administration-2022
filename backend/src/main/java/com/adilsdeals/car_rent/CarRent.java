package com.adilsdeals.car_rent;

import com.adilsdeals.car.Car;
import com.adilsdeals.models.Duration;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "car_rent")
public class CarRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name="repair_time")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startTime", column = @Column(name = "rent_start_time")),
            @AttributeOverride(name = "finishTime", column = @Column(name = "rent_finish_time"))
    })
    private Duration rentTime;

    @JoinColumn(name = "car_id")
    @ManyToOne()
    private Car car;
}
