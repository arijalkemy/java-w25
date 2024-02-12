package org.example.service;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.repository.ICrudRepository;
import org.example.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    private final ICrudRepository<Invoice> invoiceRepository;
    private final ICrudRepository<Customer> customerRepository;

    public InvoiceService(ICrudRepository<Customer> customerRepository) {
        this.invoiceRepository = new InvoiceRepository(new ArrayList<>());
        this.customerRepository = customerRepository;
    }

    public boolean add(Invoice newInvoice) {
        if(newInvoice.getItems() == null || newInvoice.getItems().isEmpty()) {
            throw new IllegalArgumentException("Invoice items cannot be null");
        }
        if (customerRepository.findById(newInvoice.getCustomer().getDni()) == null) {
            customerRepository.add(newInvoice.getCustomer());
        }
        return invoiceRepository.add(newInvoice);
    }

    public List<Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

}
