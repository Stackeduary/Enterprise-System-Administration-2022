package com.adilsdeals.car_repair;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.adilsdeals.car_repair.dto.CarRepairDto;

@RestController
@RequestMapping("/cars/repair")
@RequiredArgsConstructor
public class CarRepairController {

    private final CarRepairService carRepairService;

    @GetMapping()
    public List<CarRepair> getCarRepairHistory(){
        return carRepairService.getCarRepairHistory();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCarRepair(@RequestBody CarRepairDto carRepair){
        return new ResponseEntity(carRepairService.createCarRepair(carRepair), HttpStatus.CREATED);
    }

    @GetMapping(value ="/{id}")
    public CarRepair getCarRepair(@PathVariable Integer id){
        return carRepairService.getCarRepair(id);
    }

    @PostMapping(value = "/finish/{id}")
    public CarRepair finishRepair(@PathVariable Integer id){
        return carRepairService.finishRepair(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarRepair(@PathVariable Integer id){
        carRepairService.deleteCarRepair(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCarRepair(@PathVariable Integer id, @RequestBody CarRepairDto carRepair){
        return new ResponseEntity(carRepairService.updateCarRepair(id, carRepair), HttpStatus.OK);
    }

}
