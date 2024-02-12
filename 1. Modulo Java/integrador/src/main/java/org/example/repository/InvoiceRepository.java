package org.example.repository;

import org.example.model.Invoice;

import java.util.List;

public class InvoiceRepository implements ICrudRepository<Invoice>{
    private final List<Invoice> invoices;

    public InvoiceRepository(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public boolean add(Invoice newItem) {
        return invoices.add(newItem);
    }

    @Override
    public boolean update(Invoice newItem, String id) {
        return invoices.stream().filter(invoice -> invoice.getId().equalsIgnoreCase(id)).findFirst()
                .map(invoice -> {
                    invoice.setCustomer(newItem.getCustomer());
                    invoice.setItems(newItem.getItems());
                    invoice.setId(newItem.getId());
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteById(String id) {
        return invoices.removeIf(customer -> customer.getId().equalsIgnoreCase(id));
    }

    @Override
    public Invoice findById(String id) {
        return invoices.stream().filter(customer -> customer.getId().equalsIgnoreCase(id)).findFirst()
                .orElse(null);
    }

    @Override
    public List<Invoice> findAll() {
        return invoices;
    }
}
