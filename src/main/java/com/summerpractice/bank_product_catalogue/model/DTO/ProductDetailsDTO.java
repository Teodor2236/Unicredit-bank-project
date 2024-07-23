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
    private Product productId;
    private Plan planType;
    private Loan loanType;
    private Investment investmentType;
    private double price;
    private String currency;
    private double interestRate;
}