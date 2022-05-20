package com.adilsdeals.car_rent;

import java.util.*;

import com.adilsdeals.car.CarEntryRepository;
import com.adilsdeals.car_rent.dto.CarRentDto;
import com.adilsdeals.models.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarRentService {

    private final CarRentRepository carRentRepository;
    private final CarEntryRepository carRepository;

    public List<CarRent> getCarRentHistory(){
        return carRentRepository.findAll();
    }

    public CarRent createCarRent(CarRentDto carRent){
        CarRent rent = new CarRent();
        rent.setRenter(carRent.getRenter());
        rent.setCar(carRepository.findById(carRent.getCar()).orElseThrow().getCar());
        rent.setRentTime(new Duration(new Date(), null));

        return carRentRepository.save(rent);
    }
    public CarRent finishCarRent(Integer id) {
        CarRent rent = carRentRepository.getById(id);
        Duration duration = rent.getRentTime();
        duration.setFinishTime(new Date());
        rent.setRentTime(duration);
        return carRentRepository.save(rent);
    }

    public CarRent getCarRent(Integer id) {
        return carRentRepository.findById(id).orElseThrow();
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
