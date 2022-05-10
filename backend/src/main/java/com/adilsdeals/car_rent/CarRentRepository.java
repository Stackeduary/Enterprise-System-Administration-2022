package com.adilsdeals.car_rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentRepository extends JpaRepository<CarRent, Integer> {
}
