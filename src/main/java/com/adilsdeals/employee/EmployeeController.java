package com.adilsdeals.employee;

import com.adilsdeals.employee.dto.EmployeeCreateDto;
import com.adilsdeals.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(
            @RequestBody EmployeeCreateDto employee) {
        try {
            EmployeeDto employeeDto = employeeService.createEmployee(
                    employee.getUsername(),
                    employee.getName(),
                    employee.getPassword(),
                    employee.getPasswordCheck());

            return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id ){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody EmployeeDto employee) {
        try{
            EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
