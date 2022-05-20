package com.adilsdeals.car_repair_bay;

import java.util.*;

import com.adilsdeals.car_repair.CarRepairRepository;
import com.adilsdeals.car_repair_bay.dto.CarRepairBayDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarRepairBayService {

    private final CarRepairBayRepository carRepairBayRepository;
    private final CarRepairRepository carRepairRepository;

    public List<CarRepairBay> getCarRepairBays(){
        List<CarRepairBay> repairBays = carRepairBayRepository.findAll();
        List<Integer> busyRepairBays = carRepairRepository.findDistinctCarRepairBays();
        repairBays.forEach(repairBay -> {
            if (busyRepairBays.contains(repairBay.getId())) {
                repairBays.remove(repairBay);
            }
        });
        return repairBays;
    }

    public CarRepairBay createCarRepairBay(){
        return carRepairBayRepository.save(new CarRepairBay());
    }

    public CarRepairBayDto getCarRepairBay(Integer id) {
        CarRepairBay repairBay = carRepairBayRepository.getById(id);
        if (carRepairRepository.existsByCarRepairBay_Id(id)) {
            return new CarRepairBayDto(repairBay.getId(), false);
        }
        return new CarRepairBayDto(repairBay.getId(), true);
    }

    public void deleteCarRepairBay(Integer id) {
        carRepairBayRepository.deleteById(id);
    }
}
