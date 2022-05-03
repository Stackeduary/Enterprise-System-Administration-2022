package com.adilsdeals.CarRepair;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRepairController {

    @Autowired
    private CarRepairService carRepairService;

    //    /cars/repair: GET
    @RequestMapping(method = RequestMethod.GET, value ="/cars/repair")
    public List<CarRepair> getCarRepairHistory(){
        return carRepairService.getCarRepairHistory();
    }

    //    /cars/repair/create: POST
    @RequestMapping(method = RequestMethod.POST, value ="/cars/repair/create")
    public void createCarRepair(@RequestBody CarRepair carRepair){
        carRepairService.createCarRepair(carRepair);
    }

    //    /cars/repair/get/{id}: GET
    @RequestMapping(method = RequestMethod.GET, value ="/cars/repair/get/{id}")
    public void getCarRepair(@PathVariable String id){
        carRepairService.getCarRepair(id);
    }

    //    /cars/repair/delete/{id}: DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "cars/repair/delete/{id}")
    public void deleteCarRepair(@PathVariable String id){
        carRepairService.deleteCarRepair(id);
    }

    //    /cars/repair/update/{id}: PUT
    @RequestMapping(method = RequestMethod.PUT, value = "cars/repair/update/{id}")
    public CarRepair updateCarRepair(@PathVariable String id, @RequestBody CarRepair carRepair){
        return carRepairService.updateCarRepair(id, carRepair);
    }



}
