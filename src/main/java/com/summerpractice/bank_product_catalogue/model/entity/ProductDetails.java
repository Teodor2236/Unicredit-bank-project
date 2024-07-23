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

    @JoinColumn(name = "product_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Product productId;

    private double price;
    private String currency;
    private double interestRate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_type", referencedColumnName = "id")
    private Plan planType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_type", referencedColumnName = "id")
    private Loan loanType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "investment_type", referencedColumnName = "id")
    private Investment investmentType;
}
