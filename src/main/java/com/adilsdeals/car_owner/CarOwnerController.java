package com.adilsdeals.car_owner;

import com.adilsdeals.car_owner.dto.CarOwnerCreateDto;
import com.adilsdeals.car_owner.dto.CarOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car-owner")
@RequiredArgsConstructor
public class CarOwnerController {
    
    private final CarOwnerService carOwnerService;

    @PostMapping("/create")
    public ResponseEntity<?> createCarOwner(@RequestBody CarOwnerCreateDto carOwnerCreateDto) {
        try {
            CarOwnerDto carOwnerDto = carOwnerService.createCarOwner(carOwnerDto);
            return new ResponseEntity<>(carOwnerDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarOwner(@PathVariable int id) {
        try {
            CarOwnerDto carOwnerDto = carOwnerService.getCarOwner(id);
            return new ResponseEntity<>(carOwnerDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCarOwners() {
        try {
            return new ResponseEntity<>(carOwnerService.getAllCarOwners(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CarOwnerDto carOwner) {
        try {
            CarOwnerDto updatedCarOwner = carOwnerService.updateCarOwner(id, carOwner);
            return new ResponseEntity<>(updatedCarOwner, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
