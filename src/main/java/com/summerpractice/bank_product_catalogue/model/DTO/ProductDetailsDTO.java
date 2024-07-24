package com.summerpractice.bank_product_catalogue.model.DTO;

import com.summerpractice.bank_product_catalogue.model.entity.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDTO {
    private Long id;
    private Product product;
    private PlanDTO planType;
    private LoanDTO loanType;
    private InvestmentDTO investmentType;
    private double price;
    private String currency;
    private double interestRate;
    private LeasingDTO leasingType;
}