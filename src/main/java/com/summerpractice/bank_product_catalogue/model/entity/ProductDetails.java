package com.summerpractice.bank_product_catalogue.model.entity;

import com.summerpractice.bank_product_catalogue.model.enums.Investment;
import com.summerpractice.bank_product_catalogue.model.enums.Loan;
import com.summerpractice.bank_product_catalogue.model.enums.Plan;
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


    @Enumerated(EnumType.STRING)
    @Column(name = "plan_type")
    private Plan planType;

    @Enumerated(EnumType.STRING)
    @Column(name = "loan_type")
    private Loan loanType;

    @Enumerated(EnumType.STRING)
    @Column(name = "investment_type")
    private Investment investmentType;

    private double price;
    private String currency;
    private double interest_rate;
}
