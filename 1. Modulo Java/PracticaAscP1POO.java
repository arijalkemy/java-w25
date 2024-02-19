
public class PracticaAscP1 {
    private String marca;
    private String color;
    private double kilometros;

    public PracticaAscP1(String marca, String color, double kilometros) {
            this.marca = marca;
            this.color = color;
            this.kilometros = kilometros;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
            String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            return marcaYColor;
    }


    public static void main(String[] args) {

        PracticaAscP1 auto1 = new PracticaAscP1("Toyota", "Camry", 25000.0);
        System.out.println(auto1.mostrarMarcaYColor());

    }
}
