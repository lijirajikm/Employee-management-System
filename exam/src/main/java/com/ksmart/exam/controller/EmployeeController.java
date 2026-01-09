package com.ksmart.exam.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ksmart.exam.contract.EmployeeRequest;
import com.ksmart.exam.contract.EmployeeResponse;
import com.ksmart.exam.model.Employee;
import com.ksmart.exam.service.EmployeeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements SecureSwaggerController{

    private final EmployeeService employeeService;
   

@PostMapping("/create")
public ResponseEntity<EmployeeResponse> createEmployee(
        @RequestBody EmployeeRequest request) {

    return new ResponseEntity<>(
            employeeService.createEmployee(request),
            HttpStatus.CREATED
    );
}

    
    @GetMapping("/getAllEmployees")
public ResponseEntity<Page<Employee>> getAllEmployees(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {

    return ResponseEntity.ok(
            employeeService.getAllEmployees(page, size)
    );
}

    @GetMapping("/{employeeCode}")
    public ResponseEntity<Employee> getEmployeeByCode(@PathVariable String employeeCode) {
        return ResponseEntity.ok(employeeService.getEmployeeByCode(employeeCode));
    }

   
    @PutMapping("/{employeeCode}")
public ResponseEntity<EmployeeResponse> updateEmployee(
        @PathVariable String employeeCode,
        @RequestBody EmployeeRequest request) {

    EmployeeResponse updatedEmployee = employeeService.updateEmployeeByCode(employeeCode, request);
    return ResponseEntity.ok(updatedEmployee);
}


    @DeleteMapping("/{employeeCode}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeCode) {
        employeeService.deleteEmployee(employeeCode);
        return ResponseEntity.noContent().build();
    }
 }

