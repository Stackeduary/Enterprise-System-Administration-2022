package com.adilsdeals.car;

import com.adilsdeals.car.Car;
import com.adilsdeals.car.dto.CarDto;
import com.adilsdeals.car.dto.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarDto createCar(String licensePlateNumber, String make, String model, int year, BigDecimal currentMarketValue, BigDecimal mileage, Customer customer, PickupLocation pickupLocation) {
        Car car = carRepository.save(
                Car.builder()
                    .licensePlateNumber(licensePlateNumber)
                    .make(make)
                    .model(model)
                    .year(year)
                    .currentMarketValue(currentMarketValue)
                    .mileage(mileage)
                    .customer(customer)
                    .pickupLocation(pickupLocation)
                    .build()
        );

        return modelMapper.map(car, CarDto.class);

    public void deleteCar(int carId) {
        carRepository.deleteById(carId);
    }

    public Object getAllCars() {
        return carRepository.findAll();
    }

    public CarDto getCar(int carId) {
        return modelMapper.map(carRepository.getById(carId), CarDto.class);
    }

    public void updateCar(int carId, String licensePlateNumber, String make, String model, int year, BigDecimal currentMarketValue, BigDecimal mileage, Customer customer, PickupLocation pickupLocation) {
        Car car = carRepository.getById(carId);
        car.setLicensePlateNumber(licensePlateNumber);
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);
        car.setCurrentMarketValue(currentMarketValue);
        car.setMileage(mileage);
        car.setCustomer(customer);
        car.setPickupLocation(pickupLocation);
        return modelMapper.map(carRepository.save(car), CarDto.class);
    
}
