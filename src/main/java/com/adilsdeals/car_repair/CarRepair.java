package com.adilsdeals.car_repair;
import com.adilsdeals.car.Car;
import com.adilsdeals.models.Duration;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="car_repair")
public class CarRepair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="status")
    private String status;

    @Column(name="repair_time")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startTime", column = @Column(name = "repair_start_time")),
            @AttributeOverride(name = "finishTime", column = @Column(name = "repair_finish_time"))
    })
    private Duration repairTime;

    @JoinColumn(name = "car")
    @ManyToOne()
    private Car car;
}

