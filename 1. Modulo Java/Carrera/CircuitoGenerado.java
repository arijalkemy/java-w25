package Carrera;

public class CircuitoGenerado {
    String tipo;
    int edad;
    private double valor;

    public CircuitoGenerado(String tipo, int edad) {
        this.tipo = tipo;
        this.edad = edad;
        valorGenerado();
    }

    private void valorGenerado(){
        int edad = getEdad();
        String tipo = getTipo();

        if (tipo == "Circuito chico"){
            if (edad < 18) this.valor = 1300;
            else this.valor = 1500;
        }

        else if (tipo == "Circuito medio"){
            if (edad < 18) this.valor = 2000;
            else this.valor = 2300;
        }

        else if (tipo == "Circuito avanzado") this.valor = 2800;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEdad() {
        return edad;
    }

    public double getValor() {
        return valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    } 
    
}
