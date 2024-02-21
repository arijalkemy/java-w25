package Supermercado.Models;

public class Cliente {
    private int id;
    private String documento;
    private String nombre;

    public Cliente(String documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
    }


    public int getId() {
        return this.id;
    }

    public int setId() {
        return id;
    }

    
    public String getDocumento() {
        return documento;
    }


    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Cliente [documento=" + documento + ", nombre=" + nombre + "]";
    }


    public void setId(int id) {
        this.id = id;
    }

    
    
}
