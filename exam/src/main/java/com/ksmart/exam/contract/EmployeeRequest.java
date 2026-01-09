package com.ksmart.exam.contract;


import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeRequest {
    private UUID id;
    @NotBlank(message = "Employee code is required")
    
    private String employeeCode;
    private String name;
    private String department;
    private String salary;
    private String email;
}

