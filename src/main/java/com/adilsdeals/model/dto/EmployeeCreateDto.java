package com.adilsdeals.model.dto;

import lombok.Data;

@Data
public class EmployeeCreateDto {
    private String username;
    private String password;
    private String passwordCheck;
    private String name;
}
