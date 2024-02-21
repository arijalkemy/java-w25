package main.java.com.bootcamp.model;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private double precioMenores;
    private double precioMayores;

    public boolean isRestriccionDeEdad() {
        return restriccionDeEdad;
    }

    private boolean restriccionDeEdad;

    public Categoria(int id, String nombre, String descripcion, Double precioMenores, double precioMayores, boolean restriccionDeEdad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMenores = precioMenores;
        this.precioMayores = precioMayores;
        this.restriccionDeEdad = restriccionDeEdad;
    }

    public double getPrecioInscripcion(int edad){
        return edad >=18 ? this.precioMayores: this.precioMenores;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioMenores=" + precioMenores +
                ", precioMayores=" + precioMayores +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

}
