package com.adilsdeals.car_repair;

import java.util.*;

import com.adilsdeals.car_repair.dto.CarRepairDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarRepairService {

    private final CarRepairRepository carRepairRepository;
    private final ObjectMapper objectMapper;

    public List<CarRepair> getCarRepairHistory(){
        return carRepairRepository.findAll();
    }

    public CarRepair createCarRepair(CarRepairDto carRepair){
        return carRepairRepository.save(objectMapper.convertValue(carRepair, CarRepair.class));
    }

    public CarRepair getCarRepair(Integer id) {
        return carRepairRepository.getById(id);
    }

    public void deleteCarRepair(Integer id) {
        carRepairRepository.deleteById(id);
    }

    public CarRepair updateCarRepair(Integer id, CarRepairDto newCarRepair) {
        CarRepair carRepair = carRepairRepository.getById(id);
        carRepair.setStatus(newCarRepair.getStatus());
        carRepair.setRepairTime(newCarRepair.getRepairTime());
        return carRepairRepository.save(carRepair);
    }
}
