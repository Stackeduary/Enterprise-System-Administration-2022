package com.adilsdeals.employee;

import com.adilsdeals.employee.Employee;
import com.adilsdeals.employee.dto.EmployeeDto;
import com.adilsdeals.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public EmployeeDto createEmployee(String username, String name, String password, String passwordConfirm) {
        if(
            username.isEmpty() || name.isEmpty() ||
            password.isEmpty() || passwordConfirm.isEmpty() ||
                    !password.equals(passwordConfirm)) {
            return null;
        }

        Employee employee = employeeRepository.save(
                Employee.builder()
                        .name(name)
                        .username(username)
                        .password(passwordEncoder.encode(password))
                        .build());

        return modelMapper.map(employee, EmployeeDto.class);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.getById(id);
        employee.setName(employeeDto.getName());
        employee.setUsername(employeeDto.getUsername());
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }
}
