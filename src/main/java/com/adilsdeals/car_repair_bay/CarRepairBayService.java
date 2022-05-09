package com.adilsdeals.car_repair_bay;

import java.util.*;

import com.adilsdeals.car_repair_bay.dto.CarRepairBayDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarRepairBayService {

    private final CarRepairBayRepository carRepairBayRepository;
    private final ObjectMapper objectMapper;

    public List<CarRepairBay> getCarRepairBays(){
        return carRepairBayRepository.findAll();
    }

    public CarRepairBay createCarRepairBay(CarRepairBayDto carRepairBay){
        return carRepairBayRepository.save(objectMapper.convertValue(carRepairBay, CarRepairBay.class));
    }

    public CarRepairBay getCarRepairBay(Integer id) {
        return carRepairBayRepository.getById(id);
    }

    public void deleteCarRepairBay(Integer id) {
        carRepairBayRepository.deleteById(id);
    }
}
