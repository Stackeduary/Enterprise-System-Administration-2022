package com.adilsdeals.car_repair;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepairRepository extends JpaRepository<CarRepair, Integer> {
    boolean existsByCarRepairBay_Id(Integer carRepairBayId);
}
