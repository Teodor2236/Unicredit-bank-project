package com.summerpractice.bank_product_catalogue.model.DTO;

import java.time.LocalDateTime;

import com.summerpractice.bank_product_catalogue.model.enums.ActionType;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
	private double loanAmount;
	private int loanTermInMonths;
	private double investmentAmount;
	private int investmentTermInMonths;
	private ActionType actionType;
	private LocalDateTime createdDate;
	private ClientDTO client;
	private ProductDetailsDTO productDetails;
}