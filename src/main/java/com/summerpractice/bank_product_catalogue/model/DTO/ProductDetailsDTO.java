package com.summerpractice.bank_product_catalogue.model.DTO;

import com.summerpractice.bank_product_catalogue.model.entity.Investment;
import com.summerpractice.bank_product_catalogue.model.entity.Loan;
import com.summerpractice.bank_product_catalogue.model.entity.Plan;
import com.summerpractice.bank_product_catalogue.model.entity.Product;
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
}