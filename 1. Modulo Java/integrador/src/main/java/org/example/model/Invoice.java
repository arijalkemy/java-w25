package org.example.model;

import java.util.List;

public class Invoice {
    private String id;
    private Customer customer;
    private List<Item> items;

    public Invoice(String id, Customer customer, List<Item> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return items.stream().map(Item::getUnitPrice).reduce(0.0, Double::sum);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }
}
