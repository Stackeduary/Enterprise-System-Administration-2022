package com.adilsdeals.car;

import com.adilsdeals.car.Car;
import com.adilsdeals.car.dto.CarDto;
import com.adilsdeals.car.models.PickupLocation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarDto createCar(String licensePlateNumber, String make, String model, int year, BigDecimal currentMarketValue, BigDecimal mileage, CarOwner carOwner, PickupLocation pickupLocation) {
        Car car = carRepository.save (modelMapper.map(CarDto, Car.class));
        return modelMapper.map(car, CarDto.class);
    }

    public void deleteCar(int carId) {
        carRepository.deleteById(carId);
    }

    public CarDto getAllCars() {
        return carRepository.findAll(); // why don't we return a list here?
    }

    public CarDto getCar(int carId) {
        return modelMapper.map(carRepository.getById(carId), CarDto.class);
    }

    public CarDto updateCar(int carId, String licensePlateNumber, String make, String model, int year, BigDecimal currentMarketValue, BigDecimal mileage, CarOwner carOwner, PickupLocation pickupLocation) {
        Car car = carRepository.getById(carId);
        return modelMapper.map(carRepository.save(car), CarDto.class);
    }
}