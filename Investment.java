package com.yourpackage;

import java.math.BigDecimal;

public class Investment {
    private String name;
    private int quantity;
    private BigDecimal purchasePrice;

    public Investment(String name, int quantity, BigDecimal purchasePrice) {
        this.name = name;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
