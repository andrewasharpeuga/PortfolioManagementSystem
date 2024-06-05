package com.portfolio.investment;

public class Stock extends Investment {
    private int shares;
    private double currentPricePerShare;
    
    public Stock(String name, double amountInvested, int shares, double currentPricePerShare) {
        super(name, amountInvested);
        this.shares = shares;
        this.currentPricePerShare = currentPricePerShare;
    }
    
    @Override
    public double getCurrentValue() {
        return shares * currentPricePerShare;
    }
}
