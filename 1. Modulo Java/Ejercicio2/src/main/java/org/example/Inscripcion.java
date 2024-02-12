package org.example;

public class Inscripcion {
    int id;
    int monto;
    Persona persona;
    Categoria categoria;

    public void calcularMonto (){
        switch (categoria.id){
            case 1:
                if (this.persona.edad > 18)
                    this.monto = 1500;
                else
                    this.monto = 1300;
                break;
            case 2:
                if (this.persona.edad > 18)
                    this.monto = 2300;
                else
                    this.monto = 2000;
                break;
            case 3:
                if (this.persona.edad > 18)
                    this.monto = 2800;
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
