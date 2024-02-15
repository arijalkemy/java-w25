public class Item {
    private String code;
    private String name;
    private int quantity;
    private double unitCost;

    public Item(String code, String name, int quantity, double unitCost) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitCost=" + unitCost +
                '}';
    }
}
