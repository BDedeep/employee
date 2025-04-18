package com.example.employee.model;

import jakarta.persistence.*;

@Entity

public class Employee {

    @Id
    private Long id;

    private String name;
    private int age;
    private String department;
    private double salary;
}
