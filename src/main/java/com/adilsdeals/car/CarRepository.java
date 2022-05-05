package com.adilsdeals.car;

// import com.adilsdeals.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findByLicensePlateNumber(String licensePlateNumber);
    
}
