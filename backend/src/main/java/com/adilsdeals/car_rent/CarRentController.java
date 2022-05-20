package com.adilsdeals.car_rent;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.adilsdeals.car_rent.dto.CarRentDto;

@RestController
@RequestMapping("/cars/rent")
@RequiredArgsConstructor
public class CarRentController {

    private final CarRentService carRentService;

    @GetMapping
    public List<CarRent> getCarRentHistory(){
        return carRentService.getCarRentHistory();
    }

    @PostMapping
    public ResponseEntity<?> createCarRent(@RequestBody CarRentDto carRent){
        return new ResponseEntity(carRentService.createCarRent(carRent), HttpStatus.CREATED);
    }

    @PutMapping(value = "/finish/{id}")
    public ResponseEntity<?> finishCarRent(@PathVariable Integer id){
        return new ResponseEntity(carRentService.finishCarRent(id), HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public CarRent getCarRent(@PathVariable Integer id){
        return carRentService.getCarRent(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarRent(@PathVariable Integer id){
        carRentService.deleteCarRent(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCarRent(@PathVariable Integer id, @RequestBody CarRentDto carRent){
        return new ResponseEntity(carRentService.updateCarRent(id, carRent), HttpStatus.OK);
    }

}
