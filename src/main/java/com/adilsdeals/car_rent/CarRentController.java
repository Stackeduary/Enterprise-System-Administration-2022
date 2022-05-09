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

    @GetMapping()
    public List<CarRent> getCarRentHistory(){
        return carRentService.getCarRentHistory();
    }

    @PostMapping(value ="/create")
    public ResponseEntity<?> createCarRent(@RequestBody CarRentDto carRent){
        return new ResponseEntity(carRentService.createCarRent(carRent), HttpStatus.CREATED);
    }

    @GetMapping(value ="/get/{id}")
    public void getCarRent(@PathVariable Integer id){
        carRentService.getCarRent(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarRent(@PathVariable Integer id){
        carRentService.deleteCarRent(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateCarRent(@PathVariable Integer id, @RequestBody CarRentDto carRent){
        return new ResponseEntity(carRentService.updateCarRent(id, carRent), HttpStatus.OK);
    }

}
