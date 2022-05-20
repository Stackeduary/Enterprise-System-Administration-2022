package com.adilsdeals.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarEntryRepository extends JpaRepository<CarEntry, Integer> {
    List<CarEntry> findAllByAvailable(boolean b);
}
