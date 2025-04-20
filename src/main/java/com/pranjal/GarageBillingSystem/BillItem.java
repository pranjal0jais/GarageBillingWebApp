package com.pranjal.GarageBillingSystem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "bill_items")
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private int quantity;

    private double price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "invoice")
    private Invoice invoice;


    public BillItem() {
    }

    public long getId() {
        return id;
    }

    public BillItem setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BillItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public BillItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public BillItem setPrice(double price) {
        this.price = price;
        return this;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public BillItem setInvoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }
}
