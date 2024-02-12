package org.example.repository;

import org.example.model.Customer;

import java.util.List;

public class CustomerRepository implements ICrudRepository<Customer>
{
    private final List<Customer> customers;

    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean add(Customer newItem) {
        return customers.add(newItem);
    }

    @Override
    public boolean update(Customer newItem, String id) {
        return customers.stream().filter(customer -> customer.getDni().equals(id)).findFirst()
                .map(customer -> {
                    customer.setDni(newItem.getDni());
                    customer.setName(newItem.getName());
                    customer.setLastName(newItem.getLastName());
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean deleteById(String id) {
        return customers.removeIf(customer -> customer.getDni().equals(id));
    }

    @Override
    public Customer findById(String id) {
        return customers.stream().filter(customer -> customer.getDni().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
