package com.adilsdeals.car;

import com.adilsdeals.car.dto.CarCreateDto;
import com.adilsdeals.car.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    
    private final CarService carService;

    @PostMapping("/create")
    public ResponseEntity<?> createCar(
            @RequestBody CarCreateDto car {
        try {
            CarDto carDto = carService.createCar(
                car.getLicensePlateNumber(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getCurrentMarketValue(),
                car.getMileage(),
                car.getCustomer(),
                car.getPickupLocation()
            );

            return new ResponseEntity<>(carDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{carId}")
    public ResponseEntity<?> getCar(@PathVariable int carId) {
        try {
            CarDto carDto = carService.getCar(carId);
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCars() {
        try {
            return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/update/{carId}")
    public ResponseEntity<?> update(@PathVariable("carId") int carId, @RequestBody CarDto car) {
        try {
            carDto updatedCar = carService.updatedCar(carId, car);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{carId}")
    public ResponseEntity<?> delete(@PathVariable("carId") int carId) {
        try {
            carService.deleteCar(carId);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }    
}
