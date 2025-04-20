package com.pranjal.GarageBillingSystem;

import java.util.Date;
import java.util.List;

public class InvoiceRequestDTO {
    private String customerName;

    private String customerPhoneNumber;

    private String carPlate;

    private Date billDate;

    private double totalCost;

    private List<BillItemRequestDTO> billItemRequestDTOS;

    public InvoiceRequestDTO(){
    }

    public InvoiceRequestDTO(String customerName, String customerPhoneNumber, String carPlate, Date billDate, double totalCost, List<BillItemRequestDTO> billItemRequestDTOS) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.carPlate = carPlate;
        this.billDate = billDate;
        this.totalCost = totalCost;
        this.billItemRequestDTOS = billItemRequestDTOS;
    }

    public String getCustomerName() {
        return customerName;
    }

    public InvoiceRequestDTO setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public InvoiceRequestDTO setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
        return this;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public InvoiceRequestDTO setCarPlate(String carPlate) {
        this.carPlate = carPlate;
        return this;
    }

    public Date getBillDate() {
        return billDate;
    }

    public InvoiceRequestDTO setBillDate(Date billDate) {
        this.billDate = billDate;
        return this;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public InvoiceRequestDTO setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public List<BillItemRequestDTO> getBillItemRequestDTOS() {
        return billItemRequestDTOS;
    }

    public InvoiceRequestDTO setBillItemRequestDTOS(List<BillItemRequestDTO> billItemRequestDTOS) {
        this.billItemRequestDTOS = billItemRequestDTOS;
        return this;
    }
}
