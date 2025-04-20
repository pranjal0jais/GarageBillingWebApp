package com.pranjal.GarageBillingSystem;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bills")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customerName;

    private String customerPhoneNumber;

    private String carPlate;

    private Date billDate;

    private double totalCost;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<BillItem> billItems;

    public Invoice(String customerName, String customerPhoneNumber, String carPlate, Date billDate, double totalCost, List<BillItem> billItems) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.carPlate = carPlate;
        this.billDate = billDate;
        this.totalCost = totalCost;
        this.billItems = billItems;
    }

    public Invoice() {
    }

    public long getId() {
        return id;
    }

    public Invoice setId(long id) {
        this.id = id;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Invoice setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public Invoice setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
        return this;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public Invoice setCarPlate(String carPlate) {
        this.carPlate = carPlate;
        return this;
    }

    public Date getBillDate() {
        return billDate;
    }

    public Invoice setBillDate(Date billDate) {
        this.billDate = billDate;
        return this;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Invoice setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public Invoice setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
        return this;
    }
}
