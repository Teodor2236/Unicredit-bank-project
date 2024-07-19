package com.summerpractice.bank_product_catalogue.model.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
    private ClientDTO client;
    private ProductDetailsDTO productDetails;
    private double loanAmount;
    private int loanTermInMonths;
    private double investmentAmount;
    private int investmentTermInMonths;
}