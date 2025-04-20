package com.pranjal.GarageBillingSystem;

public class BillItemRequestDTO {
    private String description;

    private int quantity;

    private double price;

    public BillItemRequestDTO(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public BillItemRequestDTO() {
    }

    public String getDescription() {
        return description;
    }

    public BillItemRequestDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public BillItemRequestDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public BillItemRequestDTO setPrice(double price) {
        this.price = price;
        return this;
    }
}
