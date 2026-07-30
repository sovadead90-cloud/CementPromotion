package com.example.invoice;

public class OrderInvoice {
    String companyName;
    double finalAmount;
    double totalWeight;

    public OrderInvoice(String companyName, double finalAmount, double totalWeight) {
        this.companyName = companyName;
        this.finalAmount = finalAmount;
        this.totalWeight = totalWeight;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getFinalAmount() {
        return finalAmount;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "companyName='" + companyName +  " totalWeight= " + totalWeight + ", finalAmount=" + finalAmount + '}';
    }
}


