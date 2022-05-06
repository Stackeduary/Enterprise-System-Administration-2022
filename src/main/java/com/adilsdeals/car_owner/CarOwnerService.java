package com.adilsdeals.car_owner;

import com.adilsdeals.car_owner.dto.CarOwnerDto;
import com.adilsdeals.car_owner.dto.CarOwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarOwnerService {
    
    private final CarOwnerRepository carOwnerRepository;
    private final ModelMapper modelMapper;

    public CarOwnerDto createCarOwner(CarOwnerDto carOwnerDto) {
        CarOwner carOwner = carOwnerRepository.save(modelMapper.map(carOwnerDto, CarOwner.class));
        return modelMapper.map(carOwner, CarOwnerDto.class);
    }

    public CarDto getCarOwner(int id) {
        return modelMapper.map(carOwnerRepository.getById(id), CarOwnerDto.class);
    }

    public CarDto getAllCarOwners() {
        // return carOwnerRepository.getAll().stream().map(carOwner -> modelMapper.map(carOwner, CarOwnerDto.class)).collect(Collectors.toList());
        return carOwnerRepository.findAll();
    }

    public CarDto updateCarOwner(int id, CarOwnerDto carOwnerDto) {
        CarOwner carOwner = carOwnerRepository.getById(id);
        return modelMapper.map(carOwnerRepository.save(carOwner), CarOwnerDto.class);
    }

    public void deleteCarOwner(int id) {
        carOwnerRepository.deleteById(id);
    }
}
