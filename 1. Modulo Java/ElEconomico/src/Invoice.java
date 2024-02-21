import java.util.List;

public class Invoice {
    private static Long idCounter = 0L;
    private Long id;
    private Client client;
    private List<Item> items;
    private Double total;

    public Invoice(Client client, List<Item> items) {
        idCounter += 1L;
        this.id = idCounter;
        this.client = client;
        this.items = items;
        this.total = this.items.stream().mapToDouble(i -> i.getPrice()).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", client=" + client + ", items=" + items + ", total=" + total + "]";
    }
}
