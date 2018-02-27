package com.premkumar.pricingengine.model;

public class Product {

    private String productName;

    private String demand;

    private String supply;

    private float choosenPrice;

    private float finalPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public float getChoosenPrice() {
        return choosenPrice;
    }

    public void setChoosenPrice(float choosenPrice) {
        this.choosenPrice = choosenPrice;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }
}
