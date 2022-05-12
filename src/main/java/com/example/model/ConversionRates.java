package com.example.model;

public class ConversionRates {
	
     private String srcCurrency;
	
	private String tgtCurrency;
	
	private double srcAmount;
	
	private double tgtAmount;

	public ConversionRates(String srcCurrency, String tgtCurrency, double srcAmount, double tgtAmount) {
		super();
		this.srcCurrency = srcCurrency;
		this.tgtCurrency = tgtCurrency;
		this.srcAmount = srcAmount;
		this.tgtAmount = tgtAmount;
	}

	public String getSrcCurrency() {
		return srcCurrency;
	}

	public void setSrcCurrency(String srcCurrency) {
		this.srcCurrency = srcCurrency;
	}

	public String getTgtCurrency() {
		return tgtCurrency;
	}

	public void setTgtCurrency(String tgtCurrency) {
		this.tgtCurrency = tgtCurrency;
	}

	public double getSrcAmount() {
		return srcAmount;
	}

	public void setSrcAmount(double srcAmount) {
		this.srcAmount = srcAmount;
	}

	public double getTgtAmount() {
		return tgtAmount;
	}

	public void setTgtAmount(double tgtAmount) {
		this.tgtAmount = tgtAmount;
	}


}
