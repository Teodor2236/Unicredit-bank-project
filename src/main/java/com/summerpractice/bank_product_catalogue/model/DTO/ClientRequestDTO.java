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
    private Long clientId;
    private Long productDetailsId;
    private double loanAmount;
    private int loanTermInMonths;
    private double investmentAmount;
    private int investmentTermInMonths;
    private ActionType actionType;
    private LocalDateTime createdDate;

	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getProductDetailsId() {
		return productDetailsId;
	}
	public void setProductDetailsId(Long productDetailsId) {
		this.productDetailsId = productDetailsId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoanTermInMonths() {
		return loanTermInMonths;
	}
	public void setLoanTermInMonths(int loanTermInMonths) {
		this.loanTermInMonths = loanTermInMonths;
	}
	public double getInvestmentAmount() {
		return investmentAmount;
	}
	public void setInvestmentAmount(double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}
	public int getInvestmentTermInMonths() {
		return investmentTermInMonths;
	}
	public void setInvestmentTermInMonths(int investmentTermInMonths) {
		this.investmentTermInMonths = investmentTermInMonths;
	}
	public ActionType getActionType() {
		return actionType;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}