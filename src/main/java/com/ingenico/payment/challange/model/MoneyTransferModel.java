package com.ingenico.payment.challange.model;

public class MoneyTransferModel {

	private String accountFrom;

	private double amount ;

	private String accountTo;

	public MoneyTransferModel(String accountFrom, double amount, String accountTo) {
		super();
		this.accountFrom = accountFrom;
		this.amount = amount;
		this.accountTo = accountTo;
	}

	public String getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}

}
