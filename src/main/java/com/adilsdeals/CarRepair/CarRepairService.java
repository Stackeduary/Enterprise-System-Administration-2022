package com.adilsdeals.CarRepair;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CarRepairService {

    private List<CarRepair> carRepairs = new ArrayList<>(Arrays.asList(
            new CarRepair("1", "Ongoing", new CarRepair.RepairTime(new Date(), new Date())),
            new CarRepair("2", "Finished", new CarRepair.RepairTime(new Date(), new Date())) // pass params?

    ));

    public List<CarRepair> getCarRepairHistory(){
        return carRepairs;
    }

    public void createCarRepair(CarRepair carRepair){
        carRepairs.add(carRepair);
    }

    public CarRepair getCarRepair(String id) {
        return carRepairs.get(Integer.parseInt(id));
    }

    public void deleteCarRepair(String id) {
        carRepairs.remove(Integer.parseInt(id));
    }

    public CarRepair updateCarRepair(String id, CarRepair carRepair) {
        carRepairs.remove(Integer.parseInt(id));
        carRepairs.add(Integer.parseInt(id), carRepair);
        return carRepair;
    }
}
