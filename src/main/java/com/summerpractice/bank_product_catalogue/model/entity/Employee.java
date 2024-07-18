package com.summerpractice.bank_product_catalogue.model.entity;

import com.summerpractice.bank_product_catalogue.model.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String names;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(unique=true, nullable=false)
    private int EGN;

    @Column(name="employee_number", unique = true, nullable=false)
    private String employeeNumber;

    @Column(nullable=false)
    private String password;

    private Role role;
}
