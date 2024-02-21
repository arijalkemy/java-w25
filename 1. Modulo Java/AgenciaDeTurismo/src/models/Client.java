package models;

import java.util.List;

public class Client {
    private Long id;
    private String name;
    private String lastname;
    
    public Client(Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public Locator buyProduct(List<Product> products){
        Locator locator = new Locator(this, products, products.stream().mapToDouble(p->p.getPrice()).sum());
        if(locator.isFull()){
            locator.setTotal(locator.getTotal() - locator.getTotal()*0.10);
        }
        if(locator.haveTwoHotelOrTwoTicket()){
            locator.setTotal(locator.getTotal() - locator.getTotal()*0.05);
        }
        if(Repository.moreOrEqTwoLocators(this)){
            locator.setTotal(locator.getTotal() - locator.getTotal()*0.05);
        }
        System.out.println("Compraste:");
        for(Product p: products){
            System.out.println(p.getDescription()+" - $"+p.getPrice());
        }
        System.out.println("Total: "+locator.getTotal()+"\n");
        return locator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
    }
}
