package model;

public class Cliente {
    String dni;
    String nombre;
    String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /*public void crearCliente(String dni, String nombre, String apellido){
        model.Cliente cliente = new model.Cliente(dni, nombre, apellido);
        System.out.println("model.Cliente nuevo: "+cliente);
    }*/



    public String toString(){
        return "nombre: "+ nombre
                + " dni: "+dni;
    }

    public void comprar() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
