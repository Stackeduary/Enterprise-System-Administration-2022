package com.adilsdeals.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeCreateDto {
    private String username;
    private String password;
    private String passwordCheck;
    private String name;
}
