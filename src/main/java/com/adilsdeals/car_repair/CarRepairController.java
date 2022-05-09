package com.adilsdeals.car_repair;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.adilsdeals.car_repair.dto.CarRepairDto;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarRepairController {

    private final CarRepairService carRepairService;

    @GetMapping(value ="/repair")
    public List<CarRepair> getCarRepairHistory(){
        return carRepairService.getCarRepairHistory();
    }

    @PostMapping(value ="/repair/create")
    public ResponseEntity<?> createCarRepair(@RequestBody CarRepairDto carRepair){
        return new ResponseEntity(carRepairService.createCarRepair(carRepair), HttpStatus.CREATED);
    }

    @GetMapping(value ="/repair/get/{id}")
    public void getCarRepair(@PathVariable Integer id){
        carRepairService.getCarRepair(id);
    }

    @DeleteMapping(value = "/repair/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarRepair(@PathVariable Integer id){
        carRepairService.deleteCarRepair(id);
    }

    @PutMapping(value = "/repair/update/{id}")
    public ResponseEntity<?> updateCarRepair(@PathVariable Integer id, @RequestBody CarRepairDto carRepair){
        return new ResponseEntity(carRepairService.updateCarRepair(id, carRepair), HttpStatus.OK);
    }

}
