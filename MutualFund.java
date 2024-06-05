package com.portfolio.investment;

public class MutualFund extends Investment {
    private double netAssetValue;
    
    public MutualFund(String name, double amountInvested, double netAssetValue) {
        super(name, amountInvested);
        this.netAssetValue = netAssetValue;
    }
    
    @Override
    public double getCurrentValue() {
        return getAmountInvested() * netAssetValue;
    }
}
