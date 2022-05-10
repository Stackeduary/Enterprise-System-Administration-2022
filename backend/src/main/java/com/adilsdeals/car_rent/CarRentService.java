package com.adilsdeals.car_rent;

import java.util.*;

import com.adilsdeals.car_rent.dto.CarRentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarRentService {

    private final CarRentRepository carRentRepository;
    private final ObjectMapper objectMapper;

    public List<CarRent> getCarRentHistory(){
        return carRentRepository.findAll();
    }

    public CarRent createCarRent(CarRentDto carRent){
        return carRentRepository.save(objectMapper.convertValue(carRent, CarRent.class));
    }

    public CarRent getCarRent(Integer id) {
        return carRentRepository.getById(id);
    }

    public void deleteCarRent(Integer id) {
        carRentRepository.deleteById(id);
    }

    public CarRent updateCarRent(Integer id, CarRentDto newCarRent) {
        CarRent carRent = carRentRepository.getById(id);
        carRent.setRentTime(newCarRent.getRentTime());
        return carRentRepository.save(carRent);
    }
}
