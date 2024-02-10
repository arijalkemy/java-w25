package org.example;

public enum Categoria {
    CIRCUITO_CHICO(1, "Circuito chico", "2 km por selva y arroyos."),
    CIRCUITO_MEDIO(2, "Circuito medio", "5 km por selva, arroyos y barro."),
    CIRCUITO_AVANZADO(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

    private final int id;
    private final String nombre;
    private final String descripcion;

    Categoria (int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId () {
        return this.id;
    }

    public String getNombre () {
        return this.nombre;
    }

    public String getDescripcion () {
        return this.descripcion;
    }
}
