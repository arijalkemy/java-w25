public class Vehicle {
    private String model;
    private String mark;
    private Integer price;

    public Vehicle(String model, String mark, Integer price) {
        this.model = model;
        this.mark = mark;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Modelo=" + model + ", Marca=" + mark + ", Precio=" + price;
    }
}
