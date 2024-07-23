package com.summerpractice.bank_product_catalogue.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", unique = false)
    private Product product;

    private double price;
    private String currency;
    private double interestRate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_type", referencedColumnName = "id", nullable = true)
    private Plan planType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_type", referencedColumnName = "id", nullable = true)
    private Loan loanType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "investment_type", referencedColumnName = "id", nullable = true)
    private Investment investmentType;
}
