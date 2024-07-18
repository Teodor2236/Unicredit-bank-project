package com.summerpractice.bank_product_catalogue.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="product_details")
public class ProductDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "product_type")
    private String productType;
    private String currency;
    private double price;
    private double interest;
    private double deposit;

    @Column(name = "installment_value")
    private double installmentValue;

    @Column(name="minimum_credit_value")
    private double minimumCreditValue;

    @Column(name="maximum_credit_value")
    private double maximumCreditValue;

    @Column(name = "loan_term_in_months")
    private int loanTermInMonths;

}
