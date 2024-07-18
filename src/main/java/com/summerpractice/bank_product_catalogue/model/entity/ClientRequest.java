package com.summerpractice.bank_product_catalogue.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="client_requests")
public class ClientRequest {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_details_id", nullable = false)
    private ProductDetails productDetails;

    @Column(name="loan_amount")
    private double loanAmount;

    @Column(name = "loan_term_in_months")
    private int loanTermInMonths;

    @Column(name = "investment_amount")
    private double investmentAmount;

    @Column(name = "investment_term_in_months")
    private int investmentTermInMonths;
}