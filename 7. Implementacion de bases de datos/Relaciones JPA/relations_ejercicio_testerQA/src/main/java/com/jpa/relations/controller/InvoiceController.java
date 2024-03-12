package com.jpa.relations.controller;


import com.jpa.relations.entity.Invoice;
import com.jpa.relations.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {


    InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @PostMapping("/new")
    public ResponseEntity<Invoice> addNewClient(@RequestBody Invoice invoice){
        return new ResponseEntity<>(invoiceService.create(invoice), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTest(){
        return new ResponseEntity<>(invoiceService.getAll(), HttpStatus.OK);
    }


}
