package com.adilsdeals.car_repair_bay;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair-bay")
@RequiredArgsConstructor
public class CarRepairBayController {

    private final CarRepairBayService carRepairBayService;

    @GetMapping
    public List<CarRepairBay> getCarRepairBayHistory(){
        return carRepairBayService.getCarRepairBays();
    }

    @PostMapping
    public ResponseEntity<?> createCarRepairBay(){
        return new ResponseEntity(carRepairBayService.createCarRepairBay(), HttpStatus.CREATED);
    }

    @GetMapping(value ="/{id}")
    public void getCarRepairBay(@PathVariable Integer id){
        carRepairBayService.getCarRepairBay(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarRepairBay(@PathVariable Integer id){
        carRepairBayService.deleteCarRepairBay(id);
    }

}
