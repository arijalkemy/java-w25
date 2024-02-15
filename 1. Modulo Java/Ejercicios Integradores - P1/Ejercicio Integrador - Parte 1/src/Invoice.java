import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Item> items;
    private double total;

    public Invoice(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
        this.total = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getQuantity() * item.getUnitCost();
        }
        return total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
