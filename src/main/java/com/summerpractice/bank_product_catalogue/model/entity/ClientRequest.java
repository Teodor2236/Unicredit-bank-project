package com.summerpractice.bank_product_catalogue.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client_requests")
public class ClientRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = "product_details_id", nullable = false)
	private ProductDetails productDetails;

	@Column(name = "loan_amount")
	private double loanAmount;

	@Column(name = "loan_term_in_months")
	private int loanTermInMonths;

	@Column(name = "investment_amount")
	private double investmentAmount;

	@Column(name = "investment_term_in_months")
	private int investmentTermInMonths;

	@Column(name = "action_type")
	private String actionType;

	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
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

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}