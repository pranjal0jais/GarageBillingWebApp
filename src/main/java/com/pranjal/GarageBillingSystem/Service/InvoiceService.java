package com.pranjal.GarageBillingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    public List<Invoice> getInvoiceByPhoneNumber(String PhoneNumber){
        return invoiceRepository.findAll()
                .stream()
                .filter(invoice ->
                        invoice.getCustomerPhoneNumber().equals(PhoneNumber)
                )
                .toList();
    }

    public List<Invoice> getInvoiceByName(String name){
        return invoiceRepository.findAll()
                .stream()
                .filter(invoice ->
                        invoice.getCustomerName().toLowerCase().contains(name.toLowerCase())
                )
                .toList();
    }

    public void save(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = new Invoice();
        invoice.setBillDate(invoiceRequestDTO.getBillDate());
        invoice.setCustomerName(invoiceRequestDTO.getCustomerName());
        invoice.setCarPlate(invoiceRequestDTO.getCarPlate());
        invoice.setCustomerPhoneNumber(invoiceRequestDTO.getCustomerPhoneNumber());
        invoice.setTotalCost(invoiceRequestDTO.getTotalCost());

        List<BillItem> billItems = new ArrayList<>();

        if (invoiceRequestDTO.getBillItemRequestDTOS() != null) {
            for (BillItemRequestDTO billItemRequestDTO : invoiceRequestDTO.getBillItemRequestDTOS()) {
                BillItem billItem = new BillItem();
                billItem.setDescription(billItemRequestDTO.getDescription());
                billItem.setPrice(billItemRequestDTO.getPrice());
                billItem.setQuantity(billItemRequestDTO.getQuantity());
                billItem.setInvoice(invoice);

                billItems.add(billItem);
            }
        }

        invoice.setBillItems(billItems);
        invoiceRepository.save(invoice);
    }

    public void delete(long id) {
        invoiceRepository.deleteById(id);
    }

    public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElseThrow(()->new RuntimeException("Invoice not " +
                "found"));
    }
}
