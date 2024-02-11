package bootcamp;

public class Serie3 <T extends Number> extends Serie<T> {

    public Serie3(){
        super();
    }
    @Override
    public T siguienteValor() {
        super.setCantIncrementos(super.getCantIncrementos()+1);
        Double result = super.getValorInicial().doubleValue() + (3 * super.getCantIncrementos());
        return (T) result;
    }


}
