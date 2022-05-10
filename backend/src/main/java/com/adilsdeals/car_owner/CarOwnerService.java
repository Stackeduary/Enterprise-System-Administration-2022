package com.adilsdeals.car_owner;

import com.adilsdeals.car_owner.dto.CarOwnerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarOwnerService {
    
    private final CarOwnerRepository carOwnerRepository;
    private final ModelMapper modelMapper;

    public CarOwner createCarOwner(CarOwnerDto carOwnerDto) {
        return carOwnerRepository.save(modelMapper.map(carOwnerDto, CarOwner.class));
    }

    public CarOwnerDto getCarOwner(int id) {
        return modelMapper.map(carOwnerRepository.getById(id), CarOwnerDto.class);
    }

    public List<CarOwner> getAllCarOwners() {
        return carOwnerRepository.findAll();
    }

    public CarOwner updateCarOwner(int id, CarOwnerDto carOwnerDto) {
        CarOwner carOwner = carOwnerRepository.getById(id);

        if(carOwnerDto.getName() != null) carOwner.setName(carOwnerDto.getName());
        if(carOwnerDto.getAddress() != null) carOwner.setAddress(carOwnerDto.getAddress());
        if(carOwnerDto.getEmail() != null) carOwner.setEmail(carOwner.getEmail());
        if(carOwnerDto.getTelephoneNumber() != null) carOwner.setTelephoneNumber(carOwner.getTelephoneNumber());

        return carOwnerRepository.save(carOwner);
    }

    public void deleteCarOwner(int id) {
        carOwnerRepository.deleteById(id);
    }
}
