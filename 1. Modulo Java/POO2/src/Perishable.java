public class Perishable extends Product{
    
    private Integer daysToExpire;

    public Perishable(String name, Double price, Integer daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    // Esta clase debe heredar de Producto y sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase Producto (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir el precio según los diasPorCaducar:
    // Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
    // Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
    // Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.
    @Override
    public Double calculate(Integer quantityOfProducts){
        return switch (this.daysToExpire) {
            case 1 -> (super.calculate(quantityOfProducts)/4);
            case 2 -> (super.calculate(quantityOfProducts)/3);
            case 3 -> (super.calculate(quantityOfProducts)/2);
            default -> super.calculate(quantityOfProducts);
        };
    }

    public Integer getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(Integer daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return super.toString()+" Perishable [daysToExpire=" + daysToExpire + "]";
    }
}
