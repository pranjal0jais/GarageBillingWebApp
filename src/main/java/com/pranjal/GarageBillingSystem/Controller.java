package com.pranjal.GarageBillingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/bill")
public class Controller {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping()
    public ResponseEntity<List<Invoice>> getAllInvoices(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phoneNumber
    ){
        if(phoneNumber != null){
            return ResponseEntity.ok(invoiceService.getInvoiceByPhoneNumber(phoneNumber));
        } else if (name != null) {
            return ResponseEntity.ok(invoiceService.getInvoiceByName(name));
        } else{
            return ResponseEntity.ok(invoiceService.getAllInvoices());
        }
    }

    @PostMapping("/save")
    public void saveInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        invoiceService.save(invoiceRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInvoice(@PathVariable long id){
        invoiceService.delete(id);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadInvoice(@PathVariable long id) throws Exception {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(InvoicePdfGenerator.generateInvoicePdf(invoice));
    }


}
