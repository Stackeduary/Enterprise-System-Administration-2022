package com.adilsdeals.car_repair;
import com.adilsdeals.car.Car;
import com.adilsdeals.car_repair_bay.CarRepairBay;
import com.adilsdeals.models.Duration;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="car_repair")
@NoArgsConstructor
public class CarRepair {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="status")
    private String status;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startTime", column = @Column(name = "repair_start_time")),
            @AttributeOverride(name = "finishTime", column = @Column(name = "repair_finish_time"))
    })
    private Duration repairTime;

    @JoinColumn(name = "car")
    @ManyToOne()
    private Car car;

    @JoinColumn(name = "car_repair_bay_id")
    @OneToOne()
    private CarRepairBay carRepairBay;
}

