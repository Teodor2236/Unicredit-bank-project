package com.summerpractice.bank_product_catalogue.model.DTO;

import com.summerpractice.bank_product_catalogue.model.entity.Product;
import com.summerpractice.bank_product_catalogue.model.enums.Loan;
import com.summerpractice.bank_product_catalogue.model.enums.Plan;
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
    private double investmentType;
    private double price;
    private String currency;
    private double interest_rate;
}