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

    private String firstName;
    private String lastName;
    private String email;
    private int EGN;

    @Column(name="employee_number")
    private String employeeNumber;
    private String password;

    private Role role;
}
