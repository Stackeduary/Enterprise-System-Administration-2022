package com.adilsdeals.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarEntryRepository extends JpaRepository<CarEntry, Integer> {
    List<CarEntry> findAllByAvailable(boolean b);
    Optional<CarEntry> findByCar_Id(Integer id);
}
