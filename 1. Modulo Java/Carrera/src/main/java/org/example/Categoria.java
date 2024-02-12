package org.example;

public class Categoria{
    int  id;
    String nombre;
    String description;

    public Categoria( int id, String nombre, String description){

        this.id= id;
        this.nombre= nombre;
        this.description= description;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){

        this.nombre= nombre;
    }


    public String getDescription(){
        return this.description;
    }

    public void setDescription(String nombre){

        this.description= description;
    }

}
