package com.adilsdeals.car_repair;

import java.util.*;

import com.adilsdeals.car.Car;
import com.adilsdeals.car.CarRepository;
import com.adilsdeals.car_repair.dto.CarRepairDto;
import com.adilsdeals.car_repair_bay.CarRepairBayRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CarRepairService {

    private final CarRepairRepository carRepairRepository;
    private final CarRepairBayRepository carRepairBayRepository;
    private final CarRepository carRepository;
    private final ObjectMapper objectMapper;

    public List<CarRepair> getCarRepairHistory(){
        return carRepairRepository.findAll();
    }

    public CarRepair createCarRepair(CarRepairDto carRepairDto){
        CarRepair carRepair = new CarRepair();
        Car car = carRepository.findById(carRepairDto.getCarId()).orElseThrow();
        if(!carRepairRepository.existsByCarRepairBay_Id(carRepairDto.getCarRepairBayId())){
            carRepair.setCarRepairBay(carRepairBayRepository.findById(carRepairDto.getCarRepairBayId()).orElseThrow());
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Car repair bay is not empty");
        }
        carRepair.setRepairTime(carRepairDto.getRepairTime());
        carRepair.setStatus(carRepairDto.getStatus());
        carRepair.setCar(car);

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
        if(newCarRepair.getCarRepairBayId() != null) {
            if(!carRepairRepository.existsByCarRepairBay_Id(newCarRepair.getCarRepairBayId())) {
                carRepair.setCarRepairBay(carRepairBayRepository.findById(newCarRepair.getCarRepairBayId()).orElseThrow());
            }
        } else if (newCarRepair.getCarRepairBayId() == -1) {
            carRepair.setCarRepairBay(null);
        }
        return carRepairRepository.save(carRepair);
    }
}
