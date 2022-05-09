package com.adilsdeals.employee;

import com.adilsdeals.employee.dto.EmployeeCreateDto;
import com.adilsdeals.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(
            @RequestBody EmployeeCreateDto employee) {
        try {
            return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> delete(@PathVariable("id") Integer id ){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") Integer id, @RequestBody EmployeeDto employee) {
        try{
            return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
