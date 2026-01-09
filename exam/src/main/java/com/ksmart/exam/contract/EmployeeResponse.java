package com.ksmart.exam.contract;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class EmployeeResponse {
    private UUID id;
    private String employeeCode;
    private String name;
    private String department;
    private String salary;
    private String email;
}
