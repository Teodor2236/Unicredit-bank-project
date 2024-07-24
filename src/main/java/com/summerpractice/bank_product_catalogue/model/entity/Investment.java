package com.summerpractice.bank_product_catalogue.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "investment")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;
}
