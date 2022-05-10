package com.adilsdeals.car_owner;

import com.adilsdeals.car_owner.dto.CarOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-owner")
@RequiredArgsConstructor
public class CarOwnerController {
    
    private final CarOwnerService carOwnerService;

    @PostMapping("/create")
    public ResponseEntity<?> createCarOwner(@RequestBody CarOwnerDto carOwnerDto) {
        try {
            return new ResponseEntity<>(carOwnerService.createCarOwner(carOwnerDto), HttpStatus.CREATED);
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

    @GetMapping()
    public ResponseEntity<List<CarOwner>> getAllCarOwners() {
        try {
            return new ResponseEntity<>(carOwnerService.getAllCarOwners(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CarOwnerDto carOwner) {
        try {
            return new ResponseEntity<>(carOwnerService.updateCarOwner(id, carOwner), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            carOwnerService.deleteCarOwner(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
