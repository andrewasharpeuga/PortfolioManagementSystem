package com.portfolio.investment;

public class Bond extends Investment {
    private double interestRate;
    private int years;
    
    public Bond(String name, double amountInvested, double interestRate, int years) {
        super(name, amountInvested);
        this.interestRate = interestRate;
        this.years = years;
    }
    
    @Override
    public double getCurrentValue() {
        return getAmountInvested() * Math.pow(1 + interestRate, years);
    }
}
