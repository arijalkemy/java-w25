public class NoPerishable extends Product{
    
    private String type;

    public NoPerishable(String name, Double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+" NoPerishable [type=" + type + "]";
    }
}
