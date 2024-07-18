package com.summerpractice.bank_product_catalogue.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "is_active")
    private boolean isActive = true;
    private String type;
    private String image_url;
    private String description;

    @OneToOne
    @JoinColumn(name="products_details_id")
    private ProductDetails productsDetails;

    @ManyToMany(mappedBy = "products")
    private Set<Client> clients;
}
