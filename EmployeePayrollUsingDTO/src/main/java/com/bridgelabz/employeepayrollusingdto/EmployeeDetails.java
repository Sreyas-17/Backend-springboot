package com.bridgelabz.employeepayrollusingdto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employeesDTO")
@Data
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
}