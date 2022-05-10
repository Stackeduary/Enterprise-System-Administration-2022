package com.adilsdeals.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEntryRepository extends JpaRepository<CarEntry, Integer> {
}
