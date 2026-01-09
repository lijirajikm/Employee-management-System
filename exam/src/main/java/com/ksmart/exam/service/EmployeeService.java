package com.ksmart.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ksmart.exam.contract.EmployeeRequest;
import com.ksmart.exam.contract.EmployeeResponse;
import com.ksmart.exam.exception.IdExistException;
import com.ksmart.exam.exception.IdNotFound;
import com.ksmart.exam.model.Employee;
import com.ksmart.exam.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    
        public EmployeeResponse createEmployee(EmployeeRequest request) {
        if (employeeRepository.findByEmployeeCode(request.getEmployeeCode()).isPresent()) {
        throw new IdExistException(request.getEmployeeCode());
    
    }

    Employee employee = modelMapper.map(request, Employee.class);

    Employee savedEmployee = employeeRepository.save(employee);

    return modelMapper.map(savedEmployee, EmployeeResponse.class);
}


    public Page<Employee> getAllEmployees(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

   
    public Employee getEmployeeByCode(String employeeCode) {
        return employeeRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with code: " + employeeCode));
    }

   
    public String deleteEmployee(String employeeCode) {
        employeeRepository.delete(getEmployeeByCode(employeeCode));
        return "Deleted Successfully";
    }

    public EmployeeResponse updateEmployeeByCode(
        String employeeCode,
        EmployeeRequest request) {

   
    Employee employee = employeeRepository.findByEmployeeCode(employeeCode)
            .orElseThrow(() -> new IdNotFound(employeeCode));

    
    if (request.getName() != null) {
        employee.setName(request.getName());
    }

    if (request.getDepartment() != null) {
        employee.setDepartment(request.getDepartment());
    }

    if (request.getSalary() != null) {
        employee.setSalary(request.getSalary());
    }

    if (request.getEmail() != null) {
        employee.setEmail(request.getEmail());
    }

   
    Employee savedEmployee = employeeRepository.save(employee);

   
    return modelMapper.map(savedEmployee, EmployeeResponse.class);
}
    }

