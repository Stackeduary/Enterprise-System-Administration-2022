package com.adilsdeals.car_owner;

import com.adilsdeals.car_owner.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarOwnerRepository extends JpaRepository<CarOwner, Integer> {
    Optional<CarOwner> findById(int id);
}