package com.adilsdeals.car;

import com.adilsdeals.car.dto.CarDto;
import com.adilsdeals.car_owner.CarOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarOwnerRepository carOwnerRepository;
    private final CarEntryRepository carEntryRepository;

    public CarEntry createCar(CarDto carDto) {
        Car car = Car.builder()
                .carOwner(carOwnerRepository.findById(carDto.getCarOwner()).orElseThrow())
                .licensePlateNumber(carDto.getLicensePlateNumber())
                .make(carDto.getMake())
                .model(carDto.getModel())
                .mileage(carDto.getMileage())
                .pickupLocation(carDto.getPickupLocation())
                .year(carDto.getYear())
                .currentMarketValue(carDto.getCurrentMarketValue())
                .build();
        CarEntry carEntry = new CarEntry();
        carEntry.setCar(car);
        carEntry.setAvailable(carDto.getAvailable());

        carRepository.save(car);
        return carEntryRepository.save(carEntry);
    }

    public void deleteCar(int carId) {
        carRepository.delete(carEntryRepository.findById(carId).orElseThrow().getCar());
        carEntryRepository.deleteById(carId);
    }

    public List<CarEntry> getAllCars() {
        return carEntryRepository.findAll();
    }

    public CarEntry getCar(int carId) {
        return carEntryRepository.findById(carId).orElseThrow();
    }

    public CarEntry updateCar(int carId, CarDto carDto) {
        CarEntry carEntry = carEntryRepository.findById(carId).orElseThrow();
        Car car = carEntry.getCar();

        if(carDto.getCarOwner() != null) car.setCarOwner(carOwnerRepository.findById(carDto.getCarOwner()).orElseThrow());
        if(carDto.getLicensePlateNumber() != null) car.setLicensePlateNumber(carDto.getLicensePlateNumber());
        if(carDto.getMake() != null) car.setMake(carDto.getMake());
        if(carDto.getModel() != null) car.setModel(carDto.getModel());
        if(carDto.getMileage() != null) car.setMileage(carDto.getMileage());
        if(carDto.getPickupLocation() != null) car.setPickupLocation(carDto.getPickupLocation());
        if(carDto.getYear() != null) car.setYear(carDto.getYear());
        if(carDto.getCurrentMarketValue() != null) car.setCurrentMarketValue(carDto.getCurrentMarketValue());
        if(carDto.getAvailable() != null) carEntry.setAvailable(carDto.getAvailable());

        carRepository.save(car);
        return carEntryRepository.save(carEntry);
    }
}