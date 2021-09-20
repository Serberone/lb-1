package com.example.lb1;

public class Stocks {
    private String nameCompany;
    private Double cost;

    public Stocks() {
        this.nameCompany = "nameCompany";
        this.cost = 1.0;
    }

    public Stocks(String nameCompany, Double cost) {
        this.nameCompany = nameCompany;
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }
    public String getNameCompany() {
        return nameCompany;
    }
}
