package com.adilsdeals.car_repair_bay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepairBayRepository extends JpaRepository<CarRepairBay, Integer> {

}
