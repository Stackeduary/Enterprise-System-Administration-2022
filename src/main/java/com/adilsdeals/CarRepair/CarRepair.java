package com.adilsdeals.CarRepair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="car_repair")
public class CarRepair {
    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Id
    private String id;

    @Column(name="status")
    private String status;

    @Column(name="repair_time")
    @Embedded
    private RepairTime repairTime;

    @Embeddable
    public static class RepairTime{
        private Date startTime;
        private Date finishTime;

        public RepairTime(Date startTime, Date finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        public RepairTime() {

        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public void setFinishTime(Date finishTime) {
            this.finishTime = finishTime;
        }
    }


}
