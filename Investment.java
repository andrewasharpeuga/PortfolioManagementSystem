package com.portfolio.investment;

public abstract class Investment {
    private String name;
    private double amountInvested;
    
    public Investment(String name, double amountInvested) {
        this.name = name;
        this.amountInvested = amountInvested;
    }
    
    public String getName() {
        return name;
    }
    
    public double getAmountInvested() {
        return amountInvested;
    }
    
    public abstract double getCurrentValue();
}
