package models;

import java.util.List;

public class Locator {
    private static Long idGenerator = 0L;
    private Long id;
    private Client client;
    private List<Product> products;
    private Double total;
    
    public Locator(Client client, List<Product> products, Double total) {
        idGenerator += 1L;
        this.id = idGenerator;
        this.client = client;
        this.products = products;
        this.total = total;
    }

    public Boolean isFull(){
        Integer[] fullValidator = {0,0,0,0};
        for(int i=0;i<this.products.size();i++){
            if(this.products.get(i) instanceof Hotel){
                fullValidator[0] = 1;
            }
            if(this.products.get(i) instanceof TravelTicket){
                fullValidator[1] = 1;
            }
            if(this.products.get(i) instanceof Transport){
                fullValidator[2] = 1;
            }
            if(this.products.get(i) instanceof Food){
                fullValidator[3] = 1;
            }
        }
        for (Integer elem : fullValidator) {
            if (elem != 1) {
                return false;
            }
        }
        return true;
    }

    public Boolean haveTwoHotelOrTwoTicket(){
        Long hotelCounter = this.products.stream().filter(p -> p instanceof Hotel).count();
        Long ticketCounter = this.products.stream().filter(p -> p instanceof TravelTicket).count();
        if(hotelCounter >= 2 || ticketCounter >= 2){
            return true;
        }
        return false;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Locator [id=" + id + ", client=" + client + ", products=" + products + ", total=" + total + "]";
    }
}
