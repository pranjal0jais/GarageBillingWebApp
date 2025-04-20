package com.pranjal.GarageBillingSystem;

import java.util.Date;
import java.util.List;

public class InvoiceResponseDTO {
    private long id;

    private String customerName;

    private String customerPhoneNumber;

    private String carPlate;

    private Date billDate;

    private double totalCost;

    private List<BillItem> billItems;

    public InvoiceResponseDTO(long id, String customerName, String customerPhoneNumber, String carPlate, Date billDate, double totalCost, List<BillItem> billItems) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.carPlate = carPlate;
        this.billDate = billDate;
        this.totalCost = totalCost;
        this.billItems = billItems;
    }

    public InvoiceResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public InvoiceResponseDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public InvoiceResponseDTO setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public InvoiceResponseDTO setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
        return this;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public InvoiceResponseDTO setCarPlate(String carPlate) {
        this.carPlate = carPlate;
        return this;
    }

    public Date getBillDate() {
        return billDate;
    }

    public InvoiceResponseDTO setBillDate(Date billDate) {
        this.billDate = billDate;
        return this;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public InvoiceResponseDTO setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public InvoiceResponseDTO setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
        return this;
    }
}
