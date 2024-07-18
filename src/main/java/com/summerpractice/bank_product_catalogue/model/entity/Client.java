package com.summerpractice.bank_product_catalogue.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private int EGN;

    @Column(name="client_number")
    private String clientNumber;

    @ManyToMany
    @JoinTable(
            name = "client_products",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
}
