package com.adilsdeals.car;

import com.adilsdeals.car.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    
    private final CarService carService;

    @PostMapping("/create")
    public ResponseEntity<?> createCar(
            @RequestBody CarDto car) {
        try {
            CarDto carDto = carService.createCar(car);
            return new ResponseEntity<>(carDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{carId}")
    public ResponseEntity<?> getCar(@PathVariable int carId) {
        try {
            CarDto carDto = carService.getCar(carId);
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCars() {
        try {
            return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{carId}")
    public ResponseEntity<?> update(@PathVariable("carId") int carId, @RequestBody CarDto car) {
        try {
            CarDto updatedCar = carService.updateCar(carId, car);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{carId}")
    public ResponseEntity<?> delete(@PathVariable("carId") int carId) {
        try {
            carService.deleteCar(carId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }    
}
