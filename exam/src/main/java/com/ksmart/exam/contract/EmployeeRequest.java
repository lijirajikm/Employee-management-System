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
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Department is required")
    private String department;
    @NotBlank(message = "Salary is required")
    private String salary;
    @Pattern(
   regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
   message = "Email must be valid"
)
    private String email;
}

