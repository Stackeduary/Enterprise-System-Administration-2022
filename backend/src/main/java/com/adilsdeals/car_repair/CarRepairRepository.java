package com.adilsdeals.car_repair;


import com.adilsdeals.car_repair_bay.CarRepairBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepairRepository extends JpaRepository<CarRepair, Integer> {
    boolean existsByCarRepairBay_Id(Integer carRepairBayId);

    @Query(value="SELECT DISTINCT car_repair.car_repair_bay_id from car_repair;", nativeQuery = true)
    List<Integer> findDistinctCarRepairBays();
}
