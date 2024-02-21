public class PracticaExcepciones {
    private Integer a;
    private Integer b;
    
    public PracticaExcepciones(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Double calcularCociente(){
        if(this.a == 0){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return (double) (this.b/this.a);
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}
