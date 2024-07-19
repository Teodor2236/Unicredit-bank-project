package com.summerpractice.bank_product_catalogue.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String names;

    @Column(unique = true)
    private String EGN;

    @Column(name = "client_number", unique = true, nullable = false)
    private String clientNumber;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String phone;
}
