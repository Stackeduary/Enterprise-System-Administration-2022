package com.adilsdeals.car;

import com.adilsdeals.car.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarDto createCar(CarDto carDto) {
        Car car = carRepository.save (modelMapper.map(carDto, Car.class));
        return modelMapper.map(car, CarDto.class);
    }

    public void deleteCar(int carId) {
        carRepository.deleteById(carId);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public CarDto getCar(int carId) {
        return modelMapper.map(carRepository.getById(carId), CarDto.class);
    }

    public CarDto updateCar(int carId, CarDto carDto) {
        Car car = carRepository.getById(carId);

        return modelMapper.map(carRepository.save(car), CarDto.class);
    }
}