package com.ksmart.exam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String employeeCode;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "salary", length = 100)
    private String salary;

    @Column(name = "email", length = 100)
    private String email;
    
    
}

