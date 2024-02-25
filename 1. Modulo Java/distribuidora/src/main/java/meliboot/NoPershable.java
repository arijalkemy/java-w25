package meliboot;

public class NoPershable extends Product{
    private  String type;

    @Override
    public String toString() {
        return "NoPershable{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public NoPershable(String name, Double price, String type) {
        super(name, price);
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
