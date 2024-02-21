package com.wipro.model;

public class Fare {
	private double amount;
	private String currency;

	public Fare(double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}
}
