package com.pranjal.GarageBillingSystem;

public class BillItemResponseDTO {
    private long id;

    private String description;

    private int quantity;

    private double price;

    public BillItemResponseDTO(long id, String description, int quantity, double price) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public BillItemResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public BillItemResponseDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BillItemResponseDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public BillItemResponseDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public BillItemResponseDTO setPrice(double price) {
        this.price = price;
        return this;
    }
}
