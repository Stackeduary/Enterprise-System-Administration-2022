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
            return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{carId}")
    public ResponseEntity<?> getCar(@PathVariable int carId) {
        try {
            return new ResponseEntity<>(carService.getCar(carId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllCars() {
        try {
            return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{carId}")
    public ResponseEntity<?> update(@PathVariable("carId") int carId, @RequestBody CarDto car) {
        try {
            return new ResponseEntity<>(carService.updateCar(carId, car), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<?> delete(@PathVariable("carId") int carId) {
        try {
            carService.deleteCar(carId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }    
}
