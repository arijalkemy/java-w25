package org.example.impresora;

import java.util.List;

public class curriculum implements Imprimible{
    private String datosPersona;
    private List<String> habilidadesPersona;

    public curriculum(String datosPersona, List<String> habilidadesPersona) {
        this.datosPersona = datosPersona;
        this.habilidadesPersona = habilidadesPersona;
    }

    @Override
    public String toString() {
        return "curriculum{" +
                "datosPersona='" + datosPersona + '\'' +
                ", habilidadesPersona=" + habilidadesPersona +
                '}';
    }

    @Override
    public void printDocument() {
        System.out.println(this);
    }
}
