import java.util.ArrayList;
import java.util.List;

public class InvoiceManagement implements CRUD<Invoice>{
    private List<Invoice> invoices = new ArrayList<>();
    private CustomerManagement customerManagement;

    public InvoiceManagement(CustomerManagement customerManagement) {
        this.customerManagement = customerManagement;
    }

    @Override
    public void add(Invoice invoice) {
        if (customerManagement.search(invoice.getCustomer().getDni()) != null) {
            invoices.add(invoice);
        } else {
            customerManagement.add(invoice.getCustomer());
            invoices.add(invoice);
        }
    }

    @Override
    public Invoice search(String id) {
        for (Invoice invoice : invoices) {
            if (invoice.getCustomer().getDni().equals(id)) {
                return invoice;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        invoices.removeIf(invoice -> invoice.getCustomer().getDni().equals(id));
    }

    @Override
    public void update(Invoice invoice) {
    }
}
