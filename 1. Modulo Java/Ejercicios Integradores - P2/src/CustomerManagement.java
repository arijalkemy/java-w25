import java.util.ArrayList;
import java.util.List;

public class CustomerManagement implements CRUD<Customer>{
    private List<Customer> customers = new ArrayList<>();
    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer search(String dni) {
        for (Customer customer : customers) {
            if (customer.getDni().equals(dni)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void delete(String dni) {
        customers.removeIf(customer -> customer.getDni().equals(dni));
    }

    @Override
    public void update(Customer customer) {
        Customer foundCustomer = search(customer.getDni());
        if (foundCustomer != null) {
            foundCustomer.setName(customer.getName());
            foundCustomer.setLastname(customer.getLastname());
        }
    }
}
