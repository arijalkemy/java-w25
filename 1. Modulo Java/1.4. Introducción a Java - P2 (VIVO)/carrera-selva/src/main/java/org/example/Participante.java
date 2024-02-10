package org.example;

public class Participante {
    private final int numParticipante;
    private final int dni;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final int celular;
    private final int numEmergencia;
    private final String rh;

    Participante (int numParticipante, int dni, String nombre, String apellido, int edad, int celular, int numEmergencia, String rh) {
        this.numParticipante = numParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.rh = rh;
    }

    public void inscribir (int numInscripcion, Categoria categoria) {
        if (Inscripcion.inscritos.containsKey(this)) {
            System.out.println("El participante ya se encuentra inscrito en una categoría");
        }
        switch (categoria) {
            case CIRCUITO_CHICO:
                if (this.edad < 18) {
                    Inscripcion.inscribir(this, new Inscripcion(numInscripcion, categoria, this, 1300));
                } else {
                    Inscripcion.inscribir(this, new Inscripcion(numInscripcion, categoria, this, 1500));
                }
                break;
            case CIRCUITO_MEDIO:
                if (this.edad < 18) {
                    Inscripcion.inscribir(this, new Inscripcion(numInscripcion, categoria, this, 2000));
                } else {
                    Inscripcion.inscribir(this, new Inscripcion(numInscripcion, categoria, this, 2300));
                }
                break;
            case CIRCUITO_AVANZADO:
                if (this.edad < 18) {
                    System.out.println("No se puede inscribir al circuito avanzado por ser menor de edad");
                } else {
                    Inscripcion.inscribir(this, new Inscripcion(numInscripcion, categoria, this, 2800));
                }
                break;
            default:
                System.out.println("Categoria no valida");
        }
    }

    public void desinscribir () {
        Inscripcion.desinscribir(this);
    }

    public int getNumParticipante () {
        return this.numParticipante;
    }

    public int getDni () {
        return this.dni;
    }

    public String getNombre () {
        return this.nombre;
    }

    public String getApellido () {
        return this.apellido;
    }

    public int getEdad () {
        return this.edad;
    }

    public int getCelular () {
        return this.celular;
    }

    public int getNumEmergencia () {
        return this.numEmergencia;
    }

    public String getRh () {
        return this.rh;
    }
}
