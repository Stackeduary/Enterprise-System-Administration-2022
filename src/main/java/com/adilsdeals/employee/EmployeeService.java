package com.adilsdeals.employee;

import com.adilsdeals.employee.dto.EmployeeCreateDto;
import com.adilsdeals.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public EmployeeDto createEmployee(EmployeeCreateDto employeeDto) throws ResponseStatusException {
        if(!employeeDto.getPassword().equals(employeeDto.getPasswordCheck())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords don't match");
        }
        Employee employee = employeeRepository.save(
                Employee.builder()
                        .name(employeeDto.getName())
                        .username(employeeDto.getUsername())
                        .password(passwordEncoder.encode(employeeDto.getPassword()))
                        .build()
        );

        return modelMapper.map(employee, EmployeeDto.class);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.getById(id);
        if (employeeDto.getName() != null) employee.setName(employeeDto.getName());
        if (employeeDto.getUsername() != null) employee.setUsername(employeeDto.getUsername());
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }
}
