package com.adilsdeals.car_owner;

import com.adilsdeals.car_owner.dto.CarOwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarOwnerService {
    
    private final CarOwnerRepository carOwnerRepository;
    private final ModelMapper modelMapper;

    public CarOwnerDto createCarOwner(CarOwnerDto carOwnerDto) {
        CarOwner carOwner = carOwnerRepository.save(modelMapper.map(carOwnerDto, CarOwner.class));
        return modelMapper.map(carOwner, CarOwnerDto.class);
    }

    public CarOwnerDto getCarOwner(int id) {
        return modelMapper.map(carOwnerRepository.getById(id), CarOwnerDto.class);
    }

    public List<CarOwnerDto> getAllCarOwners() {
        return carOwnerRepository
                .findAll().stream()
                .map(carOwner -> modelMapper.map(carOwner, CarOwnerDto.class))
                .collect(Collectors.toList());
    }

    public CarOwnerDto updateCarOwner(int id, CarOwnerDto carOwnerDto) {
        CarOwner carOwner = carOwnerRepository.getById(id);

        if(carOwnerDto.getName() != null) carOwner.setName(carOwnerDto.getName());
        if(carOwnerDto.getAddress() != null) carOwner.setAddress(carOwnerDto.getAddress());
        if(carOwnerDto.getEmail() != null) carOwner.setEmail(carOwner.getEmail());
        if(carOwnerDto.getTelephoneNumber() != null) carOwner.setTelephoneNumber(carOwner.getTelephoneNumber());

        return modelMapper.map(carOwnerRepository.save(carOwner), CarOwnerDto.class);
    }

    public void deleteCarOwner(int id) {
        carOwnerRepository.deleteById(id);
    }
}
