package com.adilsdeals.car_repair;

import java.util.*;

import com.adilsdeals.car.*;
import com.adilsdeals.car_repair.dto.CarRepairDto;
import com.adilsdeals.car_repair_bay.CarRepairBayRepository;
import com.adilsdeals.models.Duration;
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
    private final CarEntryRepository carRepository;
    private final CarService carService;
    private final ObjectMapper objectMapper;

    public List<CarRepair> getCarRepairHistory(){
        return carRepairRepository.findAll();
    }

    public CarRepair createCarRepair(CarRepairDto carRepairDto){
        CarRepair carRepair = new CarRepair();
        CarEntry car = carRepository.findById(carRepairDto.getCarId()).orElseThrow();
        if(!car.getAvailable()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car is not available");
        }
        if(!carRepairRepository.existsByCarRepairBay_Id(carRepairDto.getCarRepairBayId())){
            carRepair.setCarRepairBay(carRepairBayRepository.findById(carRepairDto.getCarRepairBayId()).orElseThrow());
        }else{
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Car repair bay is not empty");
        }
        carService.setAvailable(car.getId(), false);
        carRepair.setRepairTime(new Duration(new Date(), null));
        carRepair.setStatus("ongoing");
        carRepair.setCar(car.getCar());

        return carRepairRepository.save(objectMapper.convertValue(carRepair, CarRepair.class));
    }

    public CarRepair getCarRepair(Integer id) {
        return carRepairRepository.findById(id).orElseThrow();
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

    public CarRepair finishRepair(Integer id) {
        CarRepair carRepair = carRepairRepository.getById(id);
        Duration duration = carRepair.getRepairTime();
        duration.setFinishTime(new Date());
        carRepair.setCarRepairBay(null);
        carRepair.setRepairTime(duration);
        carRepair.setStatus("finished");
        Car car = carRepair.getCar();
        carService.setAvailable(carRepository.findByCar_Id(car.getId()).orElseThrow().getId(), true);
        return carRepairRepository.save(carRepair);
    }
}
