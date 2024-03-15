package com.jpa.relations.service;

import com.jpa.relations.entity.Invoice;
import com.jpa.relations.repositorory.IInvoiceRepository;
import com.jpa.relations.repositorory.IItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    public final IInvoiceRepository invoiceRepository;
    public final IItemRepository itemRepository;

    public InvoiceService(IInvoiceRepository invoiceRepository, IItemRepository itemRepository) {
        this.invoiceRepository = invoiceRepository;
        this.itemRepository = itemRepository;
    }

    public Invoice create(Invoice invoice) {
        System.out.println(invoice);
        Invoice invoiceToSave = new Invoice();
        invoiceToSave.setClient(invoice.getClient());
        invoiceToSave.setInvoice_items(invoice.getInvoice_items().stream().map(itemRepository::save).toList());
        return invoiceRepository.save(invoice);
    }

    public Invoice update(Long id, Invoice updInvoice) {
        Optional<Invoice> optInvoice = invoiceRepository.findById(id);

        optInvoice = Optional.of(updInvoice);
        optInvoice.get().setId(id);

        return invoiceRepository.save(optInvoice.get());
    }

    public List<Invoice> getAll() {
       return invoiceRepository.findAll();
    }
}
