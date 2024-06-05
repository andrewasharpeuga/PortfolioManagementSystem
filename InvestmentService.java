package com.portfolio.investment;

import java.util.ArrayList;
import java.util.List;

public class InvestmentService {
    private List<Investment> investments = new ArrayList<>();
    
    public void addInvestment(Investment investment) {
        investments.add(investment);
    }
    
    public void removeInvestment(Investment investment) {
        investments.remove(investment);
    }
    
    public List<Investment> getInvestments() {
        return investments;
    }
    
    public double getTotalCurrentValue() {
        return investments.stream().mapToDouble(Investment::getCurrentValue).sum();
    }
}
